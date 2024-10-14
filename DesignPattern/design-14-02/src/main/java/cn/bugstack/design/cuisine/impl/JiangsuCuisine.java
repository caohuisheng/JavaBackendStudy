package cn.bugstack.design.cuisine.impl;

import cn.bugstack.design.cook.ICook;
import cn.bugstack.design.cuisine.ICuisine;

/**
 * Author: chs
 * Description: 江苏菜品
 * CreateTime: 2024-10-14
 */
public class JiangsuCuisine implements ICuisine {

    private ICook cook;

    public JiangsuCuisine(ICook cook){
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }

}
