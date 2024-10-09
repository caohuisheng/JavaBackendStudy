package cn.bugstack.design;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-08
 */
public class ApiTest {

    @Test
    public void test(){
        EngineController engineController = new EngineController();
        String res = engineController.process("10001", "man", 35);
        System.out.println("测试结果：" + res);
    }

}
