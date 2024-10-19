package cn.bugstack.design;

import cn.bugstack.design.user.User;
import cn.bugstack.design.user.impl.Student;
import cn.bugstack.design.user.impl.Teacher;
import cn.bugstack.design.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: chs
 * Description: 数据看板
 * CreateTime: 2024-10-19
 */
public class DataView {

    private List<User> userList = new ArrayList<>();

    public DataView(){
        userList.add(new Student("钱三一", "重点班", "三年一班"));
        userList.add(new Student("江天昊", "实验班", "三年二班"));
        userList.add(new Student("林妙妙", "普通版", "三年四班"));
        userList.add(new Student("邓小琪", "普通版", "三年四班"));
        userList.add(new Teacher("张老师","特级教师","三年一班"));
        userList.add(new Teacher("李老师","特级教师","三年二班"));
        userList.add(new Teacher("刘老师","普通教师","三年四班"));
        userList.add(new Teacher("王老师","实习教师","三年四班"));
    }

    //展示
    public void show(Visitor visitor){
        for(User user:userList){
            user.accept(visitor);
        }
    }

}
