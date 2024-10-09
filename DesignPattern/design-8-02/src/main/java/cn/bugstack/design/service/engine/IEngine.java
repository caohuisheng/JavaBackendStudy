package cn.bugstack.design.service.engine;

import cn.bugstack.design.model.aggregate.TreeRich;
import cn.bugstack.design.model.vo.EngineResult;

import java.util.Map;

/**
 * Author: chs
 * Description: 决策引擎接口
 * CreateTime: 2024-10-09
 */
public interface IEngine {

    EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String,String> decisionMatter);

}
