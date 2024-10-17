package cn.bugstack.design.mediator;

import java.util.List;

/**
 * Author: chs
 * Description: SqlSession接口
 * CreateTime: 2024-10-15
 */
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);

    void close();

}
