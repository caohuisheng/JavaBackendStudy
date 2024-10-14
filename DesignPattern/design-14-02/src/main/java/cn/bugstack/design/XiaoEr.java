package cn.bugstack.design;

import cn.bugstack.design.cuisine.ICuisine;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: chs
 * Description: 饭店小二
 * CreateTime: 2024-10-14
 */
public class XiaoEr {

    private List<ICuisine> cuisineList = new ArrayList<>();

    public void order(ICuisine cuisine){
        cuisineList.add(cuisine);
    }

    //显示菜单,并开始制作菜品
    public void placeOrder(){
        for(ICuisine cuisine:cuisineList){
            cuisine.cook();
        }
        cuisineList.clear();
    }

}
