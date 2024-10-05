package cn.bugstack.design.floor;

import cn.bugstack.design.Matter;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: 地板（德尔）
 * CreateTime: 2024-10-05
 */
public class DerFloor implements Matter {

    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "德尔(Der)";
    }

    @Override
    public String model() {
        return "第一代+";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(119);
    }

    @Override
    public String desc() {
        return "Der德尔集团是全球领先的专业木板制造商，北京2008年奥运会家装和公装地板供应商。";
    }
}
