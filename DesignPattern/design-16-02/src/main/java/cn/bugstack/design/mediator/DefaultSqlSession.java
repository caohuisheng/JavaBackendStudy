package cn.bugstack.design.mediator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Date;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-15
 */
public class DefaultSqlSession implements SqlSession {

    private Connection connection;
    private Map<String, XNode> mapperElement;

    public DefaultSqlSession(Connection connection, Map<String, XNode> mapperElement) {
        this.connection = connection;
        this.mapperElement = mapperElement;
    }

    @Override
    public <T> T selectOne(String statement) {
        try {
            XNode xNode = mapperElement.get(statement);
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> objects = resultSet2Obj(resultSet, Class.forName(xNode.getResultType()));
            return objects.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        XNode xNode = mapperElement.get(statement);
        Map<Integer, String> parameterMap = xNode.getParameter();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            buildParameter(preparedStatement, parameter, parameterMap);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> objects = resultSet2Obj(resultSet, Class.forName(xNode.getResultType()));
            return objects.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> List<T> selectList(String statement) {
        XNode xNode = mapperElement.get(statement);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet2Obj(resultSet, Class.forName(xNode.getResultType()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T> List<T> selectList(String statement, Object parameter) {
        XNode xNode = mapperElement.get(statement);
        Map<Integer, String> parameterMap = xNode.getParameter();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            buildParameter(preparedStatement, parameter, parameterMap);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet2Obj(resultSet, Class.forName(xNode.getResultType()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() {
        if(null == connection) return;
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private <T> List<T> resultSet2Obj(ResultSet resultSet, Class<?> clazz) {
        List<T> res = new ArrayList<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            //遍历每一行结果
            while(resultSet.next()){
                //创建一个对象实例
                T obj = (T)clazz.newInstance();
                //遍历该行数据的每一个字段
                for(int i = 1;i < columnCount; i++){
                    Object value = resultSet.getObject(i);
                    String columnName = metaData.getColumnName(i);
                    //获取字段的set方法，并将值设置到对象中
                    String setMethod = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                    Method method;
                    if(value instanceof LocalDateTime) method = clazz.getMethod(setMethod, LocalDateTime.class);
                    else method = clazz.getMethod(setMethod, value.getClass());
                    method.invoke(obj, value);
                }
                //将该对象添加到集合中
                res.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    private void buildParameter(PreparedStatement preparedStatement, Object parameter, Map<Integer, String> parameterMap) throws SQLException, IllegalAccessException {
        int size = parameterMap.size();
        //1.单个参数
        if(parameter instanceof Long){
            for (int i = 1; i <= size; i++) {
                preparedStatement.setLong(i, Long.parseLong(parameter.toString()));
            }
            return;
        }

        if(parameter instanceof Integer){
            for (int i = 1; i <= size; i++) {
                preparedStatement.setInt(i, Integer.parseInt(parameter.toString()));
            }
            return;
        }

        if(parameter instanceof String){
            for (int i = 1; i <= size; i++) {
                preparedStatement.setString(i, parameter.toString());
            }
            return;
        }

        //2.对象参数
        Map<String, Object> fieldMap = new HashMap<>();
        Field[] declaredFields = parameter.getClass().getDeclaredFields();
        for(Field field:declaredFields){
            String name = field.getName();
            field.setAccessible(true);
            Object obj = field.get(parameter);
            field.setAccessible(false);
            fieldMap.put(name, obj);
        }

        //给preparedStatement设置每个字段的值
        for (int i = 1; i <= size; i++) {
            String parameterDefine = parameterMap.get(i);
            Object obj = fieldMap.get(parameterDefine);

            if(obj instanceof Short){
                preparedStatement.setShort(i, Short.parseShort(obj.toString()));
            }else if(obj instanceof Integer){
                preparedStatement.setInt(i, Integer.parseInt(obj.toString()));
            }else if(obj instanceof Long){
                preparedStatement.setLong(i, Long.parseLong(obj.toString()));
            }else if(obj instanceof String){
                preparedStatement.setString(i, obj.toString());
            }else if(obj instanceof Date){
                preparedStatement.setDate(i, (java.sql.Date) obj);
            }
        }
    }
}
