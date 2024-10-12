package cn.bugstack.design.controller;

import cn.bugstack.design.door.annotation.DoDoor;
import cn.bugstack.design.domain.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-10
 */
@RestController
public class HelloWorldController {

    @Value("${server.port}")
    private int port;

    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单用户, 拦截请求！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId){
        return new UserInfo("林更新：" + userId, 19, "武汉市新洲区旧街街");
    }

}
