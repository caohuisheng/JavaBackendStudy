package cn.bugstack.design.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description: 外部订单服务
 * CreateTime: 2024-10-07
 */
public class POPOrderService {

    private Logger log = LoggerFactory.getLogger(POPOrderService.class);

    public boolean queryUserOrderCount(String userId){
        log.info("POP商家，查询用户的订单是否为首单：{}",userId);
        return true;
    }

}
