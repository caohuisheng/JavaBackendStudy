package cn.bugstack.design.impl;

import cn.bugstack.design.HttpClient;
import cn.bugstack.design.NetMall;
import com.alibaba.fastjson.JSON;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class JingDongNetMall extends NetMall {

    public JingDongNetMall(String uId, String uPwd){
        super(uId, uPwd);
    }

    @Override
    protected Boolean login(String uId, String uPwd) {
        log.info("模拟京东用户登录 uId:{} uPwd:{}", uId, uPwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String resp = HttpClient.doGet(skuUrl);
        //"(?<=title\\>).*(?=</title)"
        Pattern pattern = Pattern.compile("(?<=title\\>).*(?=</title>)");
        Matcher matcher = pattern.matcher(resp);
        Map<String, String> infoMap = new HashMap<>();
        if(matcher.find()){
            infoMap.put("name", matcher.group());
        }
        infoMap.put("price", "4799.0");
        log.info("模拟京东商品爬虫解析：{} | {}元 {}", infoMap.get("name"), infoMap.get("price"), skuUrl);
        return infoMap;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        log.info("模拟生成京东商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }
}
