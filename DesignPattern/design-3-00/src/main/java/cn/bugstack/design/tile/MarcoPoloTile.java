package cn.bugstack.design.tile;

import cn.bugstack.design.Matter;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: 瓷砖（马可波罗）
 * CreateTime: 2024-10-05
 */
public class MarcoPoloTile implements Matter {

    @Override
    public String scene() {
        return "瓷砖";
    }

    @Override
    public String brand() {
        return "马可波罗";
    }

    @Override
    public String model() {
        return "第三代";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(140);
    }

    @Override
    public String desc() {
        return "马可波罗品牌诞生于1996年，作为国内最早品牌化的建陶品牌，以文化建陶占领市场，享有仿古砖至尊的美誉。";
    }

}
