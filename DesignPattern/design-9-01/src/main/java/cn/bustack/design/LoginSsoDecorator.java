package cn.bustack.design;

import cn.bugstack.design.SsoInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-10
 */
public class LoginSsoDecorator extends SsoInterceptor {

    private static Map<String, String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua","queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        //模拟获取cookie
        String ticket = request.substring(1, 8);
        //模拟校验
        boolean success = ticket.equals("success");

        if(!success) return false;

        String userId = request.substring(9);
        String methodId = authMap.get(userId);

        return "queryUserInfo".equals(methodId);
    }
}
