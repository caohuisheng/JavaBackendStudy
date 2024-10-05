package cn.bugstack.design.tile;

import cn.bugstack.design.Matter;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: 瓷砖（东鹏）
 * CreateTime: 2024-10-05
 */
public class DongPengTile implements Matter {

    @Override
    public String scene() {
        return "瓷砖";
    }

    @Override
    public String brand() {
        return "东鹏";
    }

    @Override
    public String model() {
        return "第三代";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(102);
    }

    @Override
    public String desc() {
        return "东鹏瓷砖以品质铸就品牌，科技推动品牌，口碑传播品牌为总之，2014年品牌价值132.35亿元，位列建陶行业榜首。";
    }

}
