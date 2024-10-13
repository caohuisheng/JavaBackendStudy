package cn.bugstack.design;

import cn.bugstack.design.impl.AuthLinkLevel1;
import cn.bugstack.design.impl.AuthLinkLevel2;
import cn.bugstack.design.impl.AuthLinkLevel3;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-13
 */
public class ApiTest {

    @Test
    public void test_AuthController() throws ParseException {
        AuthLink authLink = new AuthLinkLevel3("100013","张总");
        authLink.appendNext(new AuthLinkLevel2("100012","刘总"))
                .appendNext(new AuthLinkLevel1("100011","李总"));
        String orderId = "204820241013";

        System.out.println("当前审核节点信息:" + authLink.doAuth("林更新",orderId, new Date()));
        System.out.println("模拟三级负责人审核:张总");
        AuthService.auth("100013",orderId);

        System.out.println("当前审核节点信息:" + authLink.doAuth("林更新",orderId, new Date()));
        System.out.println("模拟三级负责人审核:刘总");
        AuthService.auth("100012",orderId);

        System.out.println("当前审核节点信息:" + authLink.doAuth("林更新",orderId, new Date()));
        System.out.println("模拟三级负责人审核:李总");
        AuthService.auth("100011",orderId);

        System.out.println("当前审核节点信息:" + authLink.doAuth("林更新",orderId, new Date()));
    }

}
