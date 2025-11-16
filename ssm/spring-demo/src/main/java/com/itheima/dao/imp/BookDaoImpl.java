package com.itheima.dao.imp;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookDaoImpl implements BookDao, InitializingBean, DisposableBean {

    private List<Integer> list;
    private Set<Integer> set;
    private Map<Integer,String> map;

    //集合注入
    public void setList(List<Integer> list) {
        this.list = list;
    }
    public void setSet(Set<Integer> set) {
        this.set = set;
    }
    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

//        public void init(){
//        System.out.println("book dao init...");
//    }
//
//    public void destroy(){
//        System.out.println("book dao destroy...");
//    }

    public BookDaoImpl(){
        System.out.println("BookDaoImpl constructing...");
    }

    @Override
    public void save() {
        System.out.println("book dao save...");
        System.out.println("遍历list："+list);
        System.out.println("遍历map："+map);
        System.out.println("遍历set："+set);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("service destroy...");
    }
}
