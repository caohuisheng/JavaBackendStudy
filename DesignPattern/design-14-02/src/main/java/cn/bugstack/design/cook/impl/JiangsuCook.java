package cn.bugstack.design.cook.impl;

import cn.bugstack.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description: 广东厨师
 * CreateTime: 2024-10-14
 */
public class JiangsuCook implements ICook {

    private Logger log = LoggerFactory.getLogger(JiangsuCook.class);

    @Override
    public void doCooking() {
        log.info("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系");
    }

}
