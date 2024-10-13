package cn.bugstack.design.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Author: chs
 * Description: 代理类定义
 * CreateTime: 2024-10-13
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Logger log = LoggerFactory.getLogger(MapperFactoryBean.class);

    //需要被代理的类
    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface){
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        //创建代理对象
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            Select select = method.getAnnotation(Select.class);
            String sql = select.value().replace("#{uId}", args[0].toString());
            log.info("SQL:{}", sql);
            return args[0] + ",hello,world!";
        };
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
