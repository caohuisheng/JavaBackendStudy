package cn.bugstack.design.service.logic;

import cn.bugstack.design.model.vo.TreeNodeLink;

import java.util.List;

/**
 * Author: chs
 * Description: 基础决策器
 * CreateTime: 2024-10-08
 */
public abstract class BaseLogic implements LogicFilter{

    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
        //遍历当前决策节点的每一个链接
        for(TreeNodeLink treeNodeLink:treeNodeLinkList){
            if(decisionLogic(matterValue, treeNodeLink)){
                return treeNodeLink.getNodeIdTo();
            }
        }
        //没有符合要求的决策，返回0L
        return 0L;
    }

    /**
     * 判断是否可以进行该决策
     * @param matterValue 决策值
     * @param treeNodeLink 节点的链接
     * @return 该链接是否可以进行决策
     */
    private boolean decisionLogic(String matterValue, TreeNodeLink treeNodeLink){
        String ruleLimitValue = treeNodeLink.getRuleLimitValue();
        switch(treeNodeLink.getRuleLimitType()){
            case 1:return matterValue.equals(ruleLimitValue);
            case 2:return Double.parseDouble(matterValue) < Double.parseDouble(ruleLimitValue);
            case 3:return Double.parseDouble(matterValue) > Double.parseDouble(ruleLimitValue);
            case 4:return Double.parseDouble(matterValue) <= Double.parseDouble(ruleLimitValue);
            case 5:return Double.parseDouble(matterValue) >= Double.parseDouble(ruleLimitValue);
            default:return false;
        }
    }

}
