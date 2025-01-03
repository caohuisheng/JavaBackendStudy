package cn.bugstack.design.model.vo;

/**
 * Author: chs
 * Description: 规则树连线
 * CreateTime: 2024-10-08
 */
public class TreeNodeLink {

    private Long nodeIdFrom;        //节点from
    private Long nodeIdTo;          //节点to
    private Integer ruleLimitType;  //限定类型（1:=, 2:>, 3:<, 4:>=, 5:<=, 6:enum）
    private String ruleLimitValue;  //限定值

    public Long getNodeIdFrom() {
        return nodeIdFrom;
    }

    public void setNodeIdFrom(Long nodeIdFrom) {
        this.nodeIdFrom = nodeIdFrom;
    }

    public Long getNodeIdTo() {
        return nodeIdTo;
    }

    public void setNodeIdTo(Long nodeIdTo) {
        this.nodeIdTo = nodeIdTo;
    }

    public Integer getRuleLimitType() {
        return ruleLimitType;
    }

    public void setRuleLimitType(Integer ruleLimitType) {
        this.ruleLimitType = ruleLimitType;
    }

    public String getRuleLimitValue() {
        return ruleLimitValue;
    }

    public void setRuleLimitValue(String ruleLimitValue) {
        this.ruleLimitValue = ruleLimitValue;
    }
}
