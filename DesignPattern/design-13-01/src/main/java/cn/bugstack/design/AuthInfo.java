package cn.bugstack.design;

/**
 * Author: chs
 * Description: 审核信息
 * CreateTime: 2024-10-13
 */
public class AuthInfo {

    private String code;     //审核状态码
    private String orderId;  //订单id
    private String authUser; //审核人

    public AuthInfo(String code, String orderId, String authUser) {
        this.code = code;
        this.orderId = orderId;
        this.authUser = authUser;
    }

    @Override
    public String toString() {
        return "{code:" + code + ", orderId:" + orderId + ", 状态:" + "待负责人审批," + authUser + "}";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAuthUser() {
        return authUser;
    }

    public void setAuthUser(String authUser) {
        this.authUser = authUser;
    }
}
