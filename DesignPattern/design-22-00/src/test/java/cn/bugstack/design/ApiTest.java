package cn.bugstack.design;

import cn.bugstack.design.visitor.impl.Parent;
import cn.bugstack.design.visitor.impl.Principle;
import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class ApiTest {

    @Test
    public void test(){
        DataView dataView = new DataView();
        System.out.println("家长视角访问：");
        dataView.show(new Parent());

        System.out.println("校长视角访问：");
        dataView.show(new Principle());
    }

}
