package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import com.sun.media.jfxmediaimpl.MediaDisposer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import sun.security.krb5.internal.crypto.Des;

import java.util.*;

public class BookDaoImpl implements BookDao, InitializingBean, DisposableBean {

    // 简单数据类型
    private String databaseName;
    private Integer connectionNum;

    private Integer[] array;
    private List<Integer> list;
    private Set<Integer> set;
    private Map<String,String> map;
    private Properties properties;

    public BookDaoImpl() {
        System.out.println("constructing...");
    }

    public BookDaoImpl(String databaseName, Integer connectionNum) {
        this.databaseName = databaseName;
        this.connectionNum = connectionNum;
    }

    // 简单类型注入
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    public void setConnectionNum(Integer connectionNum) {
        System.out.println("setConnectionNum...");
        this.connectionNum = connectionNum;
    }

    //集合注入
    public void setArray(Integer[] array) {
        this.array = array;
    }
    public void setList(List<Integer> list) {
        this.list = list;
    }
    public void setSet(Set<Integer> set) {
        this.set = set;
    }
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    public void setProperties(Properties properties){
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println("book dao save...");
        // System.out.println("遍历array："+ Arrays.toString(array));
        // System.out.println("遍历list："+list);
        // System.out.println("遍历map："+map);
        // System.out.println("遍历set："+set);
        // System.out.println("遍历properties："+properties);
    }

    public void initMethod(){
        System.out.println("initMethod...");
    }

    public void destroyMethod(){
        System.out.println("destroyMethod...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy...");
    }
}
