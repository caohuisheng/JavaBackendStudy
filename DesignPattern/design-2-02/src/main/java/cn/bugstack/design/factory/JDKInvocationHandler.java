package cn.bugstack.design.factory;

import cn.bugstack.design.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter){
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method m = ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args));
        return m.invoke(cacheAdapter,args);
    }
}
