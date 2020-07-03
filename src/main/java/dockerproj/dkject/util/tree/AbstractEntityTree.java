package dockerproj.dkject.util.tree;

import java.util.List;

/**
 * 生成树数据的接收类
 *
 */
public class AbstractEntityTree implements ITree {

	private String id;
	
	private String parentId;
	
	private String label;

	private String originType;

	private List children;

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOriginType() {
		return originType;
	}

	public void setOriginType(String originType) {
		this.originType = originType;
	}

	@Override
	public List getChildren() {
		return children;
	}

	@Override
	public void setChildren(List children) {
		this.children = children;
	}
}
