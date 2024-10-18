package cn.bugstack.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Author: chs
 * Description: 摇号服务实现类
 * CreateTime: 2024-10-18
 */
public class LotteryServiceImpl implements LotteryService {

    private Logger log = LoggerFactory.getLogger(LotteryServiceImpl.class);

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    public LotteryResult doDraw(String uId) {
        //摇号
        String lottery = minibusTargetService.lottery(uId);
        //发短信
        log.info("给用户 {} 发送短信通知：{}", uId, lottery);
        //发MQ消息
        log.info("记录用户 {} 摇号结果：{}",uId, lottery);

        //返回摇号结果
        return new LotteryResult(uId, lottery, new Date());
    }
}
