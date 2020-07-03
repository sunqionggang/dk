package dockerproj.dkject.util.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取树型工具类
 */
public class TreeUtil {
	private static Logger logger = LoggerFactory.getLogger(TreeUtil.class);

	public static <T extends ITree> List<T> getTreeList(List<T> entityList){
		Map<String,T> treeMapTmp = new HashMap<>();

		Map<String,List<T>> childrenTmpMap = new HashMap<>();

		if(entityList!=null&&entityList.size()>0){
			for (T entity : entityList) {
				String entityKey = entity.getId();
				String parentEntityKey = entity.getParentId();
				treeMapTmp.put(entityKey,entity);
				if(childrenTmpMap.containsKey(entityKey)){
					treeMapTmp.get(entityKey).setChildren(childrenTmpMap.get(entityKey));
					childrenTmpMap.remove(entityKey);
				}

				if(treeMapTmp.containsKey(parentEntityKey)){
					T parentEntity = treeMapTmp.get(parentEntityKey);
					if(parentEntity.getChildren()==null){
						parentEntity.setChildren(new ArrayList<>());
					}
					parentEntity.getChildren().add(entity);
				}else{
					if(!childrenTmpMap.containsKey(parentEntityKey)){
						childrenTmpMap.put(parentEntityKey,new ArrayList<T>());
					}
					childrenTmpMap.get(parentEntityKey).add(entity);
				}
			}
		}

		//is root node or not
		List<T> rootNodes = new ArrayList<>();
		if(treeMapTmp!=null&&treeMapTmp.size()>0){
			for (String entityKey : treeMapTmp.keySet()) {
				String parentId = treeMapTmp.get(entityKey).getParentId();
				if(!treeMapTmp.containsKey(parentId)){//Yes
					logger.debug("check root node ==>id:{},parentId:{}",entityKey,parentId);
					rootNodes.add(treeMapTmp.get(entityKey));
				}
			}
		}

		return rootNodes;
	}

	//获取顶层节点
	public static <T extends ITree> List<T> getTreeList(String topId, List<T> entityList){
		List<T> resultList = new ArrayList<>();//存储顶层的数据
		
		Map<Object, T> treeMap = new HashMap<>();
		T itemTree;
		
		for(int i=0;i<entityList.size()&&!entityList.isEmpty();i++) {
			itemTree = entityList.get(i);
			treeMap.put(itemTree.getId(),itemTree);//把所有的数据放到map当中，id为key
			if(topId.equals(itemTree.getParentId()) || itemTree.getParentId() == null) {//把顶层数据放到集合中
				resultList.add(itemTree);
			}
		}
		
		//循环数据，把数据放到上一级的childen属性中
		for(int i = 0; i< entityList.size()&&!entityList.isEmpty();i++) {
			itemTree = entityList.get(i);
			T data = treeMap.get(itemTree.getParentId());//在map集合中寻找父亲
			if(data != null) {//判断父亲有没有
				if(data.getChildren() == null) {
					data.setChildren(new ArrayList<>());
				}
				data.getChildren().add(itemTree);//把子节点 放到父节点childList当中
				treeMap.put(itemTree.getParentId(), data);//把放好的数据放回map当中
			}
		}
		return resultList;
	}
}
