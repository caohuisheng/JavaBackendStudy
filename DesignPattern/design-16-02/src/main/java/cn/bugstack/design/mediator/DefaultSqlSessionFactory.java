package cn.bugstack.design.mediator;

/**
 * Author: chs
 * Description: SqlSession工厂实现类
 * CreateTime: 2024-10-16
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration){
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration.connection, configuration.mapperElement);
    }
}
