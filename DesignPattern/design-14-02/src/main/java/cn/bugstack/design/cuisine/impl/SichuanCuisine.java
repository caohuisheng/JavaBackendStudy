package cn.bugstack.design.cuisine.impl;

import cn.bugstack.design.cook.ICook;
import cn.bugstack.design.cuisine.ICuisine;

/**
 * Author: chs
 * Description: 四川菜品
 * CreateTime: 2024-10-14
 */
public class SichuanCuisine implements ICuisine {

    private ICook cook;

    public SichuanCuisine(ICook cook){
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }

}
