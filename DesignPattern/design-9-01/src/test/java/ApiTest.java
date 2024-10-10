import cn.bustack.design.LoginSsoDecorator;
import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-10
 */
public class ApiTest {

    @Test
    public void test_LoginSsoDecorator() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator();
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "wecdqwt401iuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行":" 拦截"));
    }

}
