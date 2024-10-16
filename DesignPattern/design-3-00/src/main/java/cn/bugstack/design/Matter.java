package cn.bugstack.design;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: 装修物料
 * CreateTime: 2024-10-05
 */
public interface Matter {

    //场景：地板、地砖、涂料、吊顶
    String scene();

    //品牌
    String brand();

    //型号
    String model();

    //平米报价
    BigDecimal price();

    //描述
    String desc();

}
