package cn.bugstack.design;

import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-03
 */
public class AwardReq {

    private String uId;                  // 用户ID
    private Integer awardType;           // 奖品类型：1-优惠劵，2-实物商品，3-第三方兑换卡（爱奇艺）
    private String awardNumber;          // 奖品编号：sku, couponNumber, cardId
    private String bizId;                // 业务id，防重复
    private Map<String, String> extMap;  // 扩展信息

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Map<String, String> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, String> extMap) {
        this.extMap = extMap;
    }
}
