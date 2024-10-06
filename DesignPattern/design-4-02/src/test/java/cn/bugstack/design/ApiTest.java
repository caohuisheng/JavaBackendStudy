package cn.bugstack.design;

import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-06
 */
public class ApiTest {

    @Test
    public void test_questionBankController(){
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("钱三一","2021214050"));
        System.out.println(questionBankController.createPaper("江天昊","2021214051"));
        System.out.println(questionBankController.createPaper("林妙妙","2021214052"));
    }

}
