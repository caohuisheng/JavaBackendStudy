package cn.bugstack.design.floor;

import cn.bugstack.design.Matter;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: 地板（圣象）
 * CreateTime: 2024-10-05
 */
public class ShengXiangFloor implements Matter {

    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "圣象";
    }

    @Override
    public String model() {
        return "第一代";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(318);
    }

    @Override
    public String desc() {
        return "圣象地板是中国地板行业著名品牌，圣象地板拥有中国驰名商标、中国品牌、国家免检、中国环境标志认证等多项荣誉。";
    }
}
