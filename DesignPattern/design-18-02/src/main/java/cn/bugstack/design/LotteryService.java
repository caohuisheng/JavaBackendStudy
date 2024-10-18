package cn.bugstack.design;

import cn.bugstack.design.event.EventManager;
import cn.bugstack.design.event.listener.MQEventListener;
import cn.bugstack.design.event.listener.MessageEventListener;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public abstract class LotteryService {

    private EventManager eventManager;

    public LotteryService(){
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId){
        LotteryResult lotteryResult = doDraw(uId);
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);

}
