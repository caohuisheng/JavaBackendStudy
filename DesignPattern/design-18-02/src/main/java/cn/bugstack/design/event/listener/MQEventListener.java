package cn.bugstack.design.event.listener;

import cn.bugstack.design.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description: 消息队列事件监听者
 * CreateTime: 2024-10-18
 */
public class MQEventListener implements EventListener {

    private Logger log = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult lotteryResult) {
        log.info("记录用户 {} 摇号结果：{}", lotteryResult.getuId(), lotteryResult.getMsg());
    }

}
