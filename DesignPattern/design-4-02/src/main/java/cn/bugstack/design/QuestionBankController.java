package cn.bugstack.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-06
 */
public class QuestionBankController {

    private QuestionBank questionBank = new QuestionBank();

    public QuestionBankController(){
        Map<String,String> map01 = new HashMap<>();
        map01.put("A","Java2 EE");
        map01.put("B","Java2 Card");
        map01.put("C","Java2 ME");
        map01.put("D","Java2 HE");
        map01.put("E","Java2 SE");

        Map<String,String> map02 = new HashMap<>();
        map02.put("A","Java程序的main方法必须写在类里面");
        map02.put("B","Java程序中可以有多个main方法");
        map02.put("C","Java程序中类名必须与文件名一样");
        map02.put("D","Java程序的main方法中如果只有一条语句，可以不用大括号括起来");

        Map<String,String> map03 = new HashMap<>();
        map03.put("A","变量由字母、下划线、数字、$符号随意组成");
        map03.put("B","变量不能以数字作为开头");
        map03.put("C","A和a在java中同一个变量");
        map03.put("D","不同类型的变量，可以起相同的名字");

        Map<String,String> map04 = new HashMap<>();
        map04.put("A","STRING");
        map04.put("B","x3x");
        map04.put("C","void");
        map04.put("D","de$f");

        Map<String,String> map05 = new HashMap<>();
        map05.put("A","31");
        map05.put("B","0");
        map05.put("C","1");
        map05.put("D","2");

        //添加选择题
        questionBank.append(new ChoiceQuestion("Java所定义的版本中不包括",map01,"D"));
        questionBank.append(new ChoiceQuestion("下列说法正确的是",map02,"A"));
        questionBank.append(new ChoiceQuestion("变量命名规范说法正确的是",map03,"B"));
        questionBank.append(new ChoiceQuestion("以下（）不是合法的标识符",map04,"C"));
        questionBank.append(new ChoiceQuestion("表达式(11+3*8)/4%3的值是",map05,"D"));
        //添加问答题
        questionBank.append(new AnswerQuestion("小红马和小黑马生的小马几条腿","4条腿"));
        questionBank.append(new AnswerQuestion("铁棒打头疼还是木棒打头疼","头最疼"));
        questionBank.append(new AnswerQuestion("什么床不能睡觉","牙床"));
        questionBank.append(new AnswerQuestion("为什么好马不吃回头草","后面的草没了"));
    }

    public String createPaper(String candidate, String number) {
        try {
            QuestionBank questionBankClone = (QuestionBank) questionBank.clone();
            questionBankClone.setCandidate(candidate);
            questionBankClone.setNumber(number);
            return questionBankClone.toString();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
