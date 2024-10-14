package cn.bugstack.design.cook.impl;

import cn.bugstack.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description: 广东厨师
 * CreateTime: 2024-10-14
 */
public class ShandongCook implements ICook {

    private Logger log = LoggerFactory.getLogger(ShandongCook.class);

    @Override
    public void doCooking() {
        log.info("山东厨师，烹饪鲁菜，以孔府风味为龙头");
    }

}
