package cn.bugstack.design.controller;

import cn.bugstack.design.domain.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-13
 */
public class HelloWorldController {

    public UserInfo queryUserInfo(String userId){
        List<String> userList = new ArrayList<>();
        userList.add("1001");
        userList.add("aaa");
        userList.add("bbb");
        if(!userList.contains(userId)){
            return new UserInfo("1111","非白名单用户, 拦截请求！");
        }

        return new UserInfo("林更新：" + userId, 19, "湖北省武汉市新洲区旧街街");
    }

}
