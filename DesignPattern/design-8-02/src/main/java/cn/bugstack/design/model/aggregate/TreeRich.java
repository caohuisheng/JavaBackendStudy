package cn.bugstack.design.model.aggregate;

import cn.bugstack.design.model.vo.TreeNode;
import cn.bugstack.design.model.vo.TreeRoot;

import java.util.Map;

/**
 * Author: chs
 * Description: 规则树聚合对象
 * CreateTime: 2024-10-08
 */
public class TreeRich {

    private TreeRoot treeRoot;               //树根信息
    private Map<Long, TreeNode> treeNodeMap; //树节点id -> 子节点

    public TreeRich(TreeRoot treeRoot, Map<Long, TreeNode> treeNodeMap) {
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
    }

    public TreeRoot getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRoot treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNode> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNode> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}
