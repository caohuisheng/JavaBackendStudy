package cn.bugstack.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-07
 */
public class FingerprintPayMode implements IPayMode {

    private Logger log = LoggerFactory.getLogger(FingerprintPayMode.class);

    @Override
    public boolean security(String uId) {
        log.info("指纹支付，风控校验指纹信息");
        return true;
    }
}
