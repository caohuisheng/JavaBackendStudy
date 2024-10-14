package cn.bugstack.design;

import cn.bugstack.design.cook.impl.GuangdongCook;
import cn.bugstack.design.cook.impl.JiangsuCook;
import cn.bugstack.design.cook.impl.ShandongCook;
import cn.bugstack.design.cook.impl.SichuanCook;
import cn.bugstack.design.cuisine.ICuisine;
import cn.bugstack.design.cuisine.impl.GuangdongCuisine;
import cn.bugstack.design.cuisine.impl.JiangsuCuisine;
import cn.bugstack.design.cuisine.impl.ShandongCuisine;
import cn.bugstack.design.cuisine.impl.SichuanCuisine;
import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-14
 */
public class ApiTest {

    @Test
    public void test(){
        ICuisine guangdongCuisine = new GuangdongCuisine(new GuangdongCook());
        ICuisine jiangsuCuisine = new JiangsuCuisine(new JiangsuCook());
        ICuisine shandongCuisine = new ShandongCuisine(new ShandongCook());
        ICuisine sichuanCuisine = new SichuanCuisine(new SichuanCook());

        //点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangdongCuisine);
        xiaoEr.order(jiangsuCuisine);
        xiaoEr.order(shandongCuisine);
        xiaoEr.order(sichuanCuisine);

        //显示菜单并开始制作
        xiaoEr.placeOrder();
    }

}
