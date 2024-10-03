package cn.bugstack.design.store;

import java.util.Map;

/**
 * Author: chs
 * Description: 发奖接口
 * CreateTime: 2024-10-04
 */
public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap);

}
