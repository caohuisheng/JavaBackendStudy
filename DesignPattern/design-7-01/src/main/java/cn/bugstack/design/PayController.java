package cn.bugstack.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-07
 */
public class PayController {

    private Logger log = LoggerFactory.getLogger(PayController.class);

    public boolean doPay(String uId, String tradeId, BigDecimal amount,int channelType,int modeType){
        if(1 == channelType){
            log.info("模拟微信渠道支付划账开始 uId:{} tradeId:{} amount:{}",uId,tradeId,amount);
            switch(modeType){
                case 1:log.info("密码支付，风控校验环境安全");break;
                case 2:log.info("人脸支付，风控校验脸部识别");break;
                case 3:log.info("指纹支付，风控校验指纹信息");break;
            }
        }else if(2 == channelType){
            log.info("模拟支付宝渠道支付划账开始 uId:{} tradeId:{} amount:{}",uId,tradeId,amount);
            switch(modeType){
                case 1:log.info("密码支付，风控校验环境安全");break;
                case 2:log.info("人脸支付，风控校验脸部识别");break;
                case 3:log.info("指纹支付，风控校验指纹信息");break;
            }
        }
        return true;
    }
}
