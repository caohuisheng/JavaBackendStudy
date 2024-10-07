package cn.bugstack.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-07
 */
public class CypherPayMode implements IPayMode {

    private Logger log = LoggerFactory.getLogger(CypherPayMode.class);

    @Override
    public boolean security(String uId) {
        log.info("密码支付，风控校验环境安全");
        return true;
    }
}
