package cn.bugstack.design;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: chs
 * Description: 装修包套餐
 * CreateTime: 2024-10-05
 */
public class DecorationPackageMenu implements IMenu{

    private List<Matter> list = new ArrayList<>(); //装修清单
    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal area;
    private Integer level;

    public DecorationPackageMenu(BigDecimal area, Integer level){
        this.area = area;
        this.level = level;
    }

    @Override
    public IMenu appendCeil(Matter matter) {
        list.add(matter);
        price.add(area.multiply(new BigDecimal(0.2)).multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendCoat(Matter matter) {
        list.add(matter);
        price.add(area.multiply(new BigDecimal(1.4)).multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendFloor(Matter matter) {
        list.add(matter);
        price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendTile(Matter matter) {
        list.add(matter);
        price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public String getDetail() {
        StringBuilder sb = new StringBuilder("****装修清单****\n" +
                "套餐等级：" + level + "\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\n" +
                "房屋面积：" + area.doubleValue() + " 平米\n" +
                "材料清单：\n");
        for(Matter matter:list){
            sb.append(matter.scene()).append(":").append(matter.brand()+"、").append(matter.model()+"、").append("平米价格：" + matter.price() + "元\n");
        }

        return sb.toString();
    }
}
