package cn.bugstack.design.event.listener;

import cn.bugstack.design.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description: 短信事件监听者
 * CreateTime: 2024-10-18
 */
public class MessageEventListener implements EventListener {

    private Logger log = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult lotteryResult) {
        log.info("给用户 {} 发送短信通知：{}", lotteryResult.getuId(), lotteryResult.getMsg());
    }

}
