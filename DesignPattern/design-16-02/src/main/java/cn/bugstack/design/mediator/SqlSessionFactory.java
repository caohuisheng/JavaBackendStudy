package cn.bugstack.design.mediator;

/**
 * Author: chs
 * Description: SqlSession工厂接口
 * CreateTime: 2024-10-16
 */
public interface SqlSessionFactory {

    SqlSession openSession();

}
