package cn.bugstack.design;

import java.util.Date;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class LotteryServiceImpl extends LotteryService {

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        String lottery = minibusTargetService.lottery(uId);
        return new LotteryResult(uId,lottery,new Date());
    }
}
