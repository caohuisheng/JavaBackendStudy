package cn.bugstack.design;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-06
 */
public class ApiTest {

    @Test
    public void test_builder(){
        Builder builder = new Builder();
        System.out.println(builder.levelOne(new BigDecimal(119.18)).getDetail());
        System.out.println(builder.levelTwo(new BigDecimal(119.28)).getDetail());
        System.out.println(builder.levelThree(new BigDecimal(119.58)).getDetail());
    }

}
