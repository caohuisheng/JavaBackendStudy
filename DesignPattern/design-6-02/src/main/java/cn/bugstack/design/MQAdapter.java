package cn.bugstack.design;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Author: chs
 * Description: MQ消息适配器接口
 * CreateTime: 2024-10-07
 */
public class MQAdapter {

    public static RebateInfo filter(String msg, Map<String,String> link) throws Exception{
        Map obj = JSON.parseObject(msg, Map.class);
        RebateInfo rebateInfo = new RebateInfo();
        //遍历每一个字段，填充rebateInfo的字段值
        for(String originField:link.keySet()){
            String newField = link.get(originField);
            Object value = obj.get(originField);
            //特殊处理：如果字段类型为Date，消息的类型为Long，需要重新转为Date类型
            if(newField.equals("bizTime")){
                value = new Date((Long) value);
            }
            //获取字段对应的set方法并设置值
            Method method = RebateInfo.class.getMethod("set" + newField.substring(0, 1).toUpperCase() + newField.substring(1),value.getClass());
            method.invoke(rebateInfo, value);
        }
        return rebateInfo;
    }

}
