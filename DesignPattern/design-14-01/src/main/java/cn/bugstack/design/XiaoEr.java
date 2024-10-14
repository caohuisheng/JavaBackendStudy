package cn.bugstack.design;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-14
 */
public class XiaoEr {

    private Logger log = LoggerFactory.getLogger(XiaoEr.class);

    private Map<Integer, String> cuisineMap = new HashMap<>();

    public void order(int cuisine){
        switch(cuisine){
            case 1:cuisineMap.put(1, "广东厨师，烹饪粤菜，以孔府风味为龙头");break;
            case 2:cuisineMap.put(2, "江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系");break;
            case 3:cuisineMap.put(3, "山东厨师，烹饪鲁菜，以孔府风味为龙头");break;
            case 4:cuisineMap.put(4, "四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系");break;
        }
    }

    public void placeOrder(){
        log.info("菜单：{}", JSON.toJSONString(cuisineMap));
    }

}
