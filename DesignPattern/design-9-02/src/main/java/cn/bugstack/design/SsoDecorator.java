package cn.bugstack.design;

/**
 * Author: chs
 * Description: 抽象装饰器
 * CreateTime: 2024-10-10
 */
public abstract class SsoDecorator implements HandlerInterceptor{

    private HandlerInterceptor handlerInterceptor;

    public SsoDecorator(HandlerInterceptor handlerInterceptor){
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }

}
