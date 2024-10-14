package cn.bugstack.design.cuisine.impl;

import cn.bugstack.design.cook.ICook;
import cn.bugstack.design.cook.impl.GuangdongCook;
import cn.bugstack.design.cuisine.ICuisine;

/**
 * Author: chs
 * Description: 广东菜品
 * CreateTime: 2024-10-14
 */
public class GuangdongCuisine implements ICuisine {

    private ICook cook;

    public GuangdongCuisine(ICook cook){
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }

}
