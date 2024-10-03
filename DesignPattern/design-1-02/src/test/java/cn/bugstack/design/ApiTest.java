package cn.bugstack.design;

import cn.bugstack.design.store.ICommodity;
import org.junit.Test;

import java.util.HashMap;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class ApiTest {

    @Test
    public void test_commodity(){
        StoreFactory storeFactory = new StoreFactory();

        ICommodity commodityService1 = storeFactory.getCommodityService(1);
        commodityService1.sendCommodity("10001","COUPON20241004","400420241004",null);

        ICommodity commodityService2 = storeFactory.getCommodityService(2);
        commodityService2.sendCommodity("10001","GOODS20241004","300420241004",new HashMap<String, String>(){{
            put("consigneeUserName","霍建华");
            put("consigneeUserPhone","17786426752");
            put("consigneeUserAddress","湖北省.武汉市.新洲区.旧街街");
        }});

        ICommodity commodityService3 = storeFactory.getCommodityService(3);
        commodityService3.sendCommodity("10001","CARD20241004", null,null);
    }

}
