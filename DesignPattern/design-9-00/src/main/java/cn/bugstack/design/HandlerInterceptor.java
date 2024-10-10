package cn.bugstack.design;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-10
 */
public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
