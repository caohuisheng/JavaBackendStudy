package cn.bugstack.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Author: chs
 * Description: 模板基类：基础电商推广服务
 * CreateTime: 2024-10-19
 */
public abstract class NetMall {

    protected Logger log = LoggerFactory.getLogger(NetMall.class);

    private String uId;
    private String uPwd;

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    /**
     * 生成商品推广海报
     * @param skuUrl 商品地址（京东、淘宝、当当）
     * @return 海报base64位信息
     */
    public String generateGoodsPoster(String skuUrl){
        if(!login(uId, uPwd)) return null;
        Map<String, String> resp = reptile(skuUrl);
        return createBase64(resp);
    }

    //模拟登录
    protected abstract Boolean login(String uId, String uPwd);

    //爬虫提取商品信息
    protected abstract Map<String, String> reptile(String skuUrl);

    //生成商品海报信息
    protected abstract String createBase64(Map<String, String> goodsInfo);
}