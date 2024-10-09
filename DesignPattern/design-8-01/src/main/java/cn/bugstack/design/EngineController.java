package cn.bugstack.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-08
 */
public class EngineController {

    private Logger log = LoggerFactory.getLogger(EngineController.class);

    public String process(String userId, String userSex, int userAge){
        log.info("ifelse方式判断用户结果 userId:{} userSex:{} userAge:{}", userId, userSex, userAge);

        if("man".equals(userSex)){
            if(userAge < 25) return "果实A";
            else return "果实B";
        }else if("woman".equals(userSex)){
            if(userAge < 25) return "果实C";
            else return "果实D";
        }
        return null;
    }

}
