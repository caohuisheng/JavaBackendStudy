package cn.bugstack.design.mediator;

import java.util.Map;

/**
 * Author: chs
 * Description: mapper节点（mapper中的每个方法是一个节点）
 * CreateTime: 2024-10-15
 */
public class XNode {

    private String namespace;       //命名空间
    private String id;              //mapper方法id
    private String parameterType;   //方法参数类型
    private String resultType;      //返回结果类型
    private String sql;             //sql语句
    private Map<Integer, String> parameter; //序号-参数名

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<Integer, String> getParameter() {
        return parameter;
    }

    public void setParameter(Map<Integer, String> parameter) {
        this.parameter = parameter;
    }
}
