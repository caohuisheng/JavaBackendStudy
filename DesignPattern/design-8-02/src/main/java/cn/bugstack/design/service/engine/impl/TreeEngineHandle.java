package cn.bugstack.design.service.engine.impl;

import cn.bugstack.design.model.aggregate.TreeRich;
import cn.bugstack.design.model.vo.EngineResult;
import cn.bugstack.design.model.vo.TreeNode;
import cn.bugstack.design.service.engine.EngineBase;

import java.util.Map;

/**
 * Author: chs
 * Description: 决策引擎实现类
 * CreateTime: 2024-10-09
 */
public class TreeEngineHandle extends EngineBase {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }

}
