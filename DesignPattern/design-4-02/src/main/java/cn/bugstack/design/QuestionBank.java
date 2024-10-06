package cn.bugstack.design;

import cn.bugstack.design.util.Topic;
import cn.bugstack.design.util.TopicShuffleUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-06
 */
public class QuestionBank implements Cloneable {

    private String candidate; //考生
    private String number;    //考号

    private ArrayList<ChoiceQuestion> choiceQuestionList = new ArrayList<>();
    private ArrayList<AnswerQuestion> answerQuestionList = new ArrayList<>();

    public QuestionBank append(ChoiceQuestion choiceQuestion){
        this.choiceQuestionList.add(choiceQuestion);
        return this;
    }

    public QuestionBank append(AnswerQuestion answerQuestion){
        this.answerQuestionList.add(answerQuestion);
        return this;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestionList = (ArrayList<ChoiceQuestion>) choiceQuestionList.clone();
        questionBank.answerQuestionList = (ArrayList<AnswerQuestion>) answerQuestionList.clone();

        //题目乱序
        Collections.shuffle(questionBank.choiceQuestionList);
        Collections.shuffle(questionBank.answerQuestionList);
        //选择题选项乱序
        for(ChoiceQuestion choiceQuestion:questionBank.choiceQuestionList){
            TopicShuffleUtil.shuffle(choiceQuestion);
        }

        return questionBank;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("考生：" + candidate +
                "\n考号：" + number + "\n" +
                "--------------------------\n" +
                "一、选择题\n\n");
        for(int i = 1;i <= choiceQuestionList.size();i++){
            ChoiceQuestion question = choiceQuestionList.get(i-1);
            sb.append("第" + i + "题：").append(question.getName() + "\n");
            Map<String,String> option = question.getOption();
            for(String key:option.keySet()){
                sb.append(key + ":").append(option.get(key) + "\n");
            }
            sb.append("答案：" + question.getKey() + "\n\n");
        }
        sb.append("二、问答题\n\n");
        for(int i = 1;i <= answerQuestionList.size();i++){
            AnswerQuestion question = answerQuestionList.get(i - 1);
            sb.append("第" + i + "题：").append(question.getName() + "\n");
            sb.append("答案：" + question.getKey() + "\n\n");
        }

        return sb.toString();
    }
}
