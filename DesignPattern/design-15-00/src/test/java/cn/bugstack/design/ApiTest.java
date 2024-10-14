package cn.bugstack.design;

import cn.bugstack.design.group.Employee;
import cn.bugstack.design.group.GroupStructure;
import cn.bugstack.design.group.Link;
import cn.bugstack.design.lang.Iterator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-14
 */
public class ApiTest {

    private Logger log = LoggerFactory.getLogger(ApiTest.class);

    /*
     0
     |
     1
    / \
    2  3
   / \
  4  5
    /|\
   6 7 8
     */
    @Test
    public void test_iterator(){
        //组织结构
        GroupStructure groupStructure = new GroupStructure("0","顶级单位");
        //添加员工
        groupStructure.add(new Employee("1","晶晶","一级部门"));
        groupStructure.add(new Employee("2","花花","二级部门"));
        groupStructure.add(new Employee("3","豆包","二级部门"));
        groupStructure.add(new Employee("4","蹦蹦","三级部门"));
        groupStructure.add(new Employee("5","大烧","三级部门"));
        groupStructure.add(new Employee("6","虎哥","四级部门"));
        groupStructure.add(new Employee("7","玲姐","四级部门"));
        groupStructure.add(new Employee("8","秋雅","四级部门"));
        //添加链接关系
        groupStructure.addLink("0",new Link("0","1"));
        groupStructure.addLink("1",new Link("1","2"));
        groupStructure.addLink("1",new Link("1","3"));
        groupStructure.addLink("2",new Link("2","4"));
        groupStructure.addLink("2",new Link("2","5"));
        groupStructure.addLink("5",new Link("5","6"));
        groupStructure.addLink("5",new Link("5","7"));
        groupStructure.addLink("5",new Link("5","8"));

        //遍历组织结构树
        Iterator<Employee> iterator = groupStructure.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            log.info("{} uId:{} name:{}",employee.getDesc(), employee.getuId(), employee.getName());
        }
    }

}
