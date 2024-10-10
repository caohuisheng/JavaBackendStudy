package cn.bugstack.design;

/**
 * Author: chs
 * Description: SSO登录拦截器
 * CreateTime: 2024-10-10
 */
public class SsoInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        String ticket = request.substring(1,8);
        return ticket.equals("success");
    }

}
