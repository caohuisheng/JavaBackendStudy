package com.itheima;

import org.junit.*;

public class MyMathtest {

    private int age;

    /*@Test
    public void testAdd(){
        MyMath math = new MyMath();
        int result = math.add(3, 10);
        System.out.println(result);
    }*/

    @BeforeClass    //常用来初始化资源
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass //常用来释放资源
    public static void afterClass(){
        System.out.println("AfterClass");
    }

    @Test
    public void testAdd(){
        MyMath math = new MyMath();
        int result = math.add(3, 10);
        System.out.println(result);

        //Assert.assertEquals(20,result);
    }

    @Before
    public void before(){
        System.out.println("before");
    }

    @After
    public void after(){
        System.out.println("after");
    }
}
