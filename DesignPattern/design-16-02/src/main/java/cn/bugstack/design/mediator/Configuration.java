package cn.bugstack.design.mediator;

import java.sql.Connection;
import java.util.Map;

/**
 * Author: chs
 * Description: 配置
 * CreateTime: 2024-10-15
 */
public class Configuration {

    protected Connection connection;            //连接
    protected Map<String, String> dataSource;   //数据源
    protected Map<String, XNode> mapperElement; //方法类路径-XNode

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setDataSource(Map<String, String> dataSource) {
        this.dataSource = dataSource;
    }

    public void setMapperElement(Map<String, XNode> mapperElement) {
        this.mapperElement = mapperElement;
    }
}
