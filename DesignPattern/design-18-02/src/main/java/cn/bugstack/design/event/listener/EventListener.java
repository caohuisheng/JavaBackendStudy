package cn.bugstack.design.event.listener;

import cn.bugstack.design.LotteryResult;

/**
 * Author: chs
 * Description: 事件监听者
 * CreateTime: 2024-10-18
 */
public interface EventListener {

    void doEvent(LotteryResult lotteryResult);

}
