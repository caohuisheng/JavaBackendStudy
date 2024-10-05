package cn.bugstack.design;

/**
 * Author: chs
 * Description: 装修套餐接口
 * CreateTime: 2024-10-05
 */
public interface IMenu {

    IMenu appendCeil(Matter matter);

    IMenu appendCoat(Matter matter);

    IMenu appendFloor(Matter matter);

    IMenu appendTile(Matter matter);

    // 获取装修套餐明细
    String getDetail();

}
