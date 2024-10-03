package cn.bugstack.design.card;

/**
 * Author: chs
 * Description: 模拟爱奇艺会员卡服务
 * CreateTime: 2024-10-03
 */
public class IQiYiCardService {

    public void grantToken(String bindMobileNumber, String cardId){
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobileNumber + "," + cardId);
    }

}
