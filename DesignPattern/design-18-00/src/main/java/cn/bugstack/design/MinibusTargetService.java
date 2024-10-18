package cn.bugstack.design;

/**
 * Author: chs
 * Description: 小客车指标调控服务
 * CreateTime: 2024-10-18
 */
public class MinibusTargetService {

    /**
     * 模拟摇号
     * @param uId
     * @return
     */
    public String lottery(String uId){
        return Math.abs(uId.hashCode()) % 2 == 0?"恭喜你，编码".concat(uId).concat("在本次摇号中签") :
                "很遗憾，编码".concat(uId).concat("在本次摇号未中签或资格已过期");
    }

}
