package cn.bugstack.design.channel;

import cn.bugstack.design.mode.IPayMode;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-07
 */
public class ZfbPay extends Pay {

    public ZfbPay(IPayMode payMode){
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        log.info("模拟支付宝渠道支付划账开始 uId:{} tradeId:{} amount:{}",uId,tradeId,amount);
        log.info("模拟支付宝支付渠道支付风控校验 uId:{} tradeId:{} amount:{}",uId,tradeId,amount);
        boolean success = payMode.security(uId);
        if(!success){
            log.info("模拟支付宝渠道支付划账拦截 uId:{} tradeId:{} amount:{}",uId,tradeId,amount);
            return "0001";
        }
        log.info("模拟支付宝渠道支付划账成功 uId:{} tradeId:{} amount:{}",uId,tradeId,amount);
        return "0000";
    }
}
