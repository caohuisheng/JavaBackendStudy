package cn.bugstack.design;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: chs
 * Description: 审核服务接口
 * CreateTime: 2024-10-13
 */
public class AuthService {

    private static Map<String, Date> authMap = new ConcurrentHashMap<>();

    //查询审核信息
    public static Date queryAuthInfo(String uId, String orderId){
        return authMap.get(uId.concat("_").concat(orderId));
    }

    //执行审核
    public static void auth(String uId, String orderId){
        authMap.put(uId.concat("_").concat(orderId), new Date());
    }

}
