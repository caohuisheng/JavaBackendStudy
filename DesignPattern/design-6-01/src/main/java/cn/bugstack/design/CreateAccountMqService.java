package cn.bugstack.design;

import cn.bugstack.design.mq.CreateAccount;
import com.alibaba.fastjson.JSON;

/**
 * Author: chs
 * Description: 接收开户服务消息服务
 * CreateTime: 2024-10-07
 */
public class CreateAccountMqService {

    public void onMessage(String message){
        CreateAccount createAccount = JSON.parseObject(message, CreateAccount.class);
        createAccount.getNumber();
        createAccount.getAccountDate();

        //...处理自己的业务
    }

}
