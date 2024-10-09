package cn.bugstack.design.service.engine;

import cn.bugstack.design.service.logic.LogicFilter;
import cn.bugstack.design.service.logic.impl.UserAgeFilter;
import cn.bugstack.design.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: chs
 * Description: 决策引擎配置
 * CreateTime: 2024-10-09
 */
public class EngineConfig {

    //过滤器名称 -> 过滤器
    private static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap(){
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        this.logicFilterMap = logicFilterMap;
    }
}
