import com.itheima.config.SpringConfig;
import com.itheima.pojo.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

//设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//设置spring环境对应的配置类
@ContextConfiguration(classes = {SpringConfig.class})
// @ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void testFindById(){
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    // @Test
    // public void testTransfer() throws IOException {
    //     accountService.transfer("Tom","Jerry",100);
    // }
}
