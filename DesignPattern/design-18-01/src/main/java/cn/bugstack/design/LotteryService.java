package cn.bugstack.design;

/**
 * Author: chs
 * Description: 摇号服务
 * CreateTime: 2024-10-18
 */
public interface LotteryService {

    LotteryResult doDraw(String uId);

}
