package cn.bugstack.design.event;

import cn.bugstack.design.LotteryResult;
import cn.bugstack.design.event.listener.EventListener;
import javafx.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: chs
 * Description: 事件管理者
 * CreateTime: 2024-10-18
 */
public class EventManager {

    private Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    public enum EventType{
        MQ, Message;
    }

    public EventManager(Enum<EventType>... eventTypes){
        for(Enum<EventType> eventType:eventTypes){
            listeners.put(eventType, new ArrayList<EventListener>());
        }
    }

    /**
     * 订阅消息
     * @param eventType 事件类型
     * @param listener 监听器
     */
    public void subscribe(Enum<EventType> eventType, EventListener listener){
        List<EventListener> eventListeners = listeners.get(eventType);
        eventListeners.add(listener);
    }

    /**
     * 取消订阅
     * @param eventType 事件类型
     * @param listener 监听器
     */
    public void unsubscribe(Enum<EventType> eventType, EventListener listener){
        List<EventListener> eventListeners = listeners.get(eventType);
        eventListeners.remove(listener);
    }

    /**
     * 通知（将结果通知给每一个监听了指定事件的监听器）
     * @param eventType 事件类型
     * @param lotteryResult 结果
     */
    public void notify(Enum<EventType> eventType, LotteryResult lotteryResult){
        List<EventListener> eventListeners = listeners.get(eventType);
        for(EventListener eventListener:eventListeners){
            eventListener.doEvent(lotteryResult);
        }
    }

}
