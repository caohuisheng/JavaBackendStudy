package cn.bugstack.design.service.logic;

import cn.bugstack.design.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * Author: chs
 * Description: 逻辑决策器接口
 * CreateTime: 2024-10-08
 */
public interface LogicFilter {

    /**
     * 执行决策
     * @param matterValue 决策值
     * @param treeNodeLinkList 当前决策节点的链接列表
     * @return 下一个节点id
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    /**
     * 获取决策值
     * @param treeId 决策树id
     * @param userId 用户id
     * @param decisionMatter 决策物料
     * @return
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

}
