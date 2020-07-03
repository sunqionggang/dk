package dockerproj.dkject.util.tree;

import java.util.List;

/**
 * 树形数据实体接口 
 * @param <T>
 */
public interface ITree {
	
     String getId();
	
     String getParentId();
    
     void setChildren(List childList);
    
     List getChildren();
}
