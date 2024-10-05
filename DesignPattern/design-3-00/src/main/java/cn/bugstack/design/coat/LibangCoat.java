package cn.bugstack.design.coat;

import cn.bugstack.design.Matter;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: 涂料(Libang)
 * CreateTime: 2024-10-05
 */
public class LibangCoat implements Matter {

    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "立邦";
    }

    @Override
    public String model() {
        return "第二代";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(650);
    }

    @Override
    public String desc() {
        return "立邦始终以开发绿色产品、注重高科技、高品质为目标，以技术力量不断推进科研和开发，满足消费者需求。";
    }
}
