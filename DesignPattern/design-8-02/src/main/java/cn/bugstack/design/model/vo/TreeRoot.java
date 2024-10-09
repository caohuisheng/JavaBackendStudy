package cn.bugstack.design.model.vo;

/**
 * Author: chs
 * Description: 树根
 * CreateTime: 2024-10-08
 */
public class TreeRoot {

    private Long treeId;          // 规则树id
    private Long treeRootNodeId;  // 规则树跟id
    private String treeName;      // 规则树名称

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeRootNodeId() {
        return treeRootNodeId;
    }

    public void setTreeRootNodeId(Long treeRootNodeId) {
        this.treeRootNodeId = treeRootNodeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }
}
