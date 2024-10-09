package cn.bugstack.design.service.logic.impl;

import cn.bugstack.design.service.logic.BaseLogic;

import java.util.Map;

/**
 * Author: chs
 * Description: 用户年龄决策器
 * CreateTime: 2024-10-09
 */
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("age");
    }
}
