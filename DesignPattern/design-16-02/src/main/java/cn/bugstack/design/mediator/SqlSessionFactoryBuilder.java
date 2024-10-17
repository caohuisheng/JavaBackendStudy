package cn.bugstack.design.mediator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: chs
 * Description: SqlSession工厂建造者
 * CreateTime: 2024-10-16
 */
public class SqlSessionFactoryBuilder {

    public DefaultSqlSessionFactory build(Reader reader){
        SAXReader saxReader = new SAXReader();
        try {
            //读取mybatis配置文件并创建SqlSessionFactory实例
            saxReader.setEntityResolver(new XMLMapperEntityResolver());
            Document document = saxReader.read(new InputSource(reader));
            Configuration configuration = parseConfiguration(document.getRootElement());
            return new DefaultSqlSessionFactory(configuration);
        } catch(DocumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    //解析数据库配置
    private Configuration parseConfiguration(Element root){
        Configuration configuration = new Configuration();
        configuration.setDataSource(dataSource(root.selectNodes("//dataSource")));
        configuration.setConnection(connection(configuration.dataSource));
        configuration.setMapperElement(mapperElement(root.selectNodes("mappers")));
        return configuration;
    }

    // 获取数据源配置信息
    private Map<String, String> dataSource(List<Element> elements){
        Map<String, String> dataSource = new HashMap<>();
        Element element = elements.get(0);
        List content = element.content();
        for(Object obj:content){
            Element e = (Element) obj;
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            dataSource.put(name, value);
        }
        return dataSource;
    }

    //通过数据源获取数据库连接
    private Connection connection(Map<String, String> dataSource){
        try {
            Class.forName(dataSource.get("driver"));
            return DriverManager.getConnection(dataSource.get("url"), dataSource.get("username"), dataSource.get("password"));
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取 方法名-XNode 映射
     * @param elements
     * @return
     */
    private Map<String, XNode> mapperElement(List<Element> elements){
        Map<String, XNode> res = new HashMap<>();

        //获取mapper列表
        Element element = elements.get(0);
        List content = element.content();
        //遍历每一个mapper
        for(Object obj:content){
            Element e = (Element) obj;
            //获取mapper对应的xml文件路径名
            String resource = e.attributeValue("resource");

            try {
                //读取mapper文件
                InputStreamReader reader = Resources.getResourceAsReader(resource);
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(new InputSource(reader));
                Element rootElement = document.getRootElement();
                //命名空间
                String namespace = rootElement.attributeValue("namespace");

                //获取所有select节点
                List<Element> selectNodes = rootElement.selectNodes("select");
                for(Element node:selectNodes){
                    String id = node.attributeValue("id");
                    String parameterType = node.attributeValue("parameterType");
                    String resultType = node.attributeValue("resultType");
                    String sql = node.getText();

                    //获取sql语句中所有参数
                    Map<Integer, String> parameter = new HashMap<>();
                    Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                    Matcher matcher = pattern.matcher(sql);
                    for(int i = 1;matcher.find();i++){
                        String g1 = matcher.group(1); //#{age}
                        String g2 = matcher.group(2); //age
                        parameter.put(i, g2);
                        sql = sql.replace(g1, "?");
                    }

                    //创建XNode对象并添加到结果中
                    XNode xNode = new XNode();
                    xNode.setNamespace(namespace);
                    xNode.setId(id);
                    xNode.setParameterType(parameterType);
                    xNode.setResultType(resultType);
                    xNode.setSql(sql);
                    xNode.setParameter(parameter);

                    res.put(namespace + "." + id, xNode);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return res;
    }

}
