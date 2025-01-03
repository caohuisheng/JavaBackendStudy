package cn.bugstack.design.cook.impl;

import cn.bugstack.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description: 广东厨师
 * CreateTime: 2024-10-14
 */
public class GuangdongCook implements ICook {

    private Logger log = LoggerFactory.getLogger(GuangdongCook.class);

    @Override
    public void doCooking() {
        log.info("广东厨师，烹饪粤菜，以孔府风味为龙头");
    }

}
