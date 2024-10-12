package cn.bugstack.design.door;

import cn.bugstack.design.door.annotation.DoDoor;
import cn.bugstack.design.door.config.StarterService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author: chs
 * Description: 白名单切面
 * CreateTime: 2024-10-12
 */
@Aspect
@Component
public class DoJointPoint {

    private Logger log = LoggerFactory.getLogger(DoJointPoint.class);

    @Autowired
    private StarterService starterService;

    @Pointcut("@annotation(cn.bugstack.design.door.annotation.DoDoor)")
    public void aopPoint(){
    }

    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint jp) throws Throwable {
        //获取内容
        Method method = getMethod(jp);
        DoDoor door = method.getAnnotation(DoDoor.class);
        //获取字段值
        String keyValue = getFieldValue(door.key(), jp.getArgs());
        log.info("itstack door handler method:{} value:{}", method.getName(), keyValue);
        if(StringUtils.isEmpty(keyValue)) return jp.proceed();
        //白名单列表
        String[] whiteList = starterService.split(",");
        //白名单过滤
        for(String white:whiteList){
            if(keyValue.equals(white)) return jp.proceed();
        }
        //不存在于白名单中，拦截
        return returnObject(door, method);
    }

    //获取被切面管理的方法
    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Class<?> jpClass = jp.getTarget().getClass();
        return jpClass.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    //被拦截时返回的默认对象
    private Object returnObject(DoDoor doDoor, Method method) throws InstantiationException, IllegalAccessException {
        Class<?> returnType = method.getReturnType();
        String returnJson = doDoor.returnJson();
        if("".equals(returnJson)){
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }

    /**
     * 返回方法所有参数对应字段名的值
     * @param field 字段名
     * @param args 方法的参数
     * @return 字段值
     */
    private String getFieldValue(String field, Object[] args){
        String fieldValue = null;
        //遍历每一个参数
        for(Object arg:args){
            try {
                fieldValue = BeanUtils.getProperty(arg, field);
                if(!StringUtils.isEmpty(fieldValue)) break;
            } catch (Exception e) {
                if(args.length == 1){
                    return args[0].toString();
                }
            }
        }
        return fieldValue;
    }

}
