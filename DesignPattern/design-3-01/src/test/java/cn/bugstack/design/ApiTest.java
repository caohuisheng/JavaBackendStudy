package cn.bugstack.design;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-05
 */
public class ApiTest {

    @Test
    public void test_decorationPackageController(){
        DecorationPackageController decoration = new DecorationPackageController();
        System.out.println(decoration.getDecorationList(new BigDecimal(139.10),1));
        System.out.println(decoration.getDecorationList(new BigDecimal(139.20),2));
        System.out.println(decoration.getDecorationList(new BigDecimal(139.40),3));
    }

}
