package cn.bugstack.design.cook.impl;

import cn.bugstack.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description: 广东厨师
 * CreateTime: 2024-10-14
 */
public class SichuanCook implements ICook {

    private Logger log = LoggerFactory.getLogger(SichuanCook.class);

    @Override
    public void doCooking() {
        log.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系");
    }

}
