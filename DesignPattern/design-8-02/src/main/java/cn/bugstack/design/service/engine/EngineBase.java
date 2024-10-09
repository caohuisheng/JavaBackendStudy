package cn.bugstack.design.service.engine;

import cn.bugstack.design.model.aggregate.TreeRich;
import cn.bugstack.design.model.vo.TreeNode;
import cn.bugstack.design.model.vo.TreeRoot;
import cn.bugstack.design.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Author: chs
 * Description: 基础决策引擎
 * CreateTime: 2024-10-09
 */
public abstract class EngineBase implements IEngine {

    private EngineConfig engineConfig = new EngineConfig();

    private Logger log = LoggerFactory.getLogger(EngineBase.class);

    /**
     * 执行决策
     * @param treeRich 规则树聚合对象
     * @param treeId 决策树id
     * @param userId 用户id
     * @param decisionMatter 决策物料
     * @return 最终的结果节点（叶子）
     */
    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter){
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        //决策树根节点id
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        //当前决策树节点
        TreeNode treeNode = treeNodeMap.get(rootNodeId);
        //所有决策器
        Map<String, LogicFilter> logicFilterMap = engineConfig.getLogicFilterMap();
        //根据决策树进行决策
        while(treeNode.getNodeType().equals(1)){
            //获取决策器
            String ruleKey = treeNode.getRuleKey();
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            //获取决策值
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            //获取下一个节点
            Long nextNodeId = logicFilter.filter(matterValue, treeNode.getTreeNodeLinkList());
            treeNode = treeNodeMap.get(nextNodeId);
            log.info("决策树引擎=>{} userId:{} treeId:{} treeNode:{} ruleKey:{} matterValue:{}", treeRoot.getTreeName(),userId,treeId,treeNode.getTreeNodeId(),ruleKey,matterValue);
        }
        //返回结果节点
        return treeNode;
    }

}
