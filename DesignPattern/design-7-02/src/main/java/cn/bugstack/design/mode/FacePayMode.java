package cn.bugstack.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-07
 */
public class FacePayMode implements IPayMode {

    private Logger log = LoggerFactory.getLogger(FacePayMode.class);

    @Override
    public boolean security(String uId) {
        log.info("人脸支付，风控校验脸部识别");
        return true;
    }
}
