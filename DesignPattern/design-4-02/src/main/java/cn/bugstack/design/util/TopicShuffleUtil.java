package cn.bugstack.design.util;

import cn.bugstack.design.ChoiceQuestion;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-06
 */
public class TopicShuffleUtil {

    /**
     * 打乱对应题目的选项，并返回新的选项和答案
     * @param option 选项列表
     * @param questionKey 选项的key
     */
    public static Topic shuffle(Map<String, String> option, String questionKey){
        //打乱后的选项
        Map<String, String> optionNew = new HashMap<>();
        //打乱后的答案key
        String questionKeyNew = null;
        //原来的答案
        String answer = option.get(questionKey);
        //原来的选项key列表
        ArrayList<String> keyList = new ArrayList<>(option.keySet());
        //原来的选项value列表
        List<String> valueList = new ArrayList<>(option.values());
        Collections.shuffle(valueList);
        for(int i=0;i<keyList.size();i++){
            optionNew.put(keyList.get(i),valueList.get(i));
            if(answer.equals(valueList.get(i))) questionKeyNew = keyList.get(i);
        }

        return new Topic(optionNew, questionKeyNew);
    }

    public static void shuffle(ChoiceQuestion choiceQuestion){
        //原来的选项和答案key
        Map<String, String> option = choiceQuestion.getOption();
        String questionKey = choiceQuestion.getKey();
        //原来的答案
        String answer = option.get(questionKey);
        //打乱后的选项和答案key
        Map<String, String> optionNew = new HashMap<>();
        String questionKeyNew = null;

        //原来的选项key列表
        ArrayList<String> keyList = new ArrayList<>(option.keySet());
        //原来的选项value列表
        List<String> valueList = new ArrayList<>(option.values());
        //打乱选项value列表
        Collections.shuffle(valueList);
        for(int i=0;i<keyList.size();i++){
            optionNew.put(keyList.get(i),valueList.get(i));
            if(answer.equals(valueList.get(i))) questionKeyNew = keyList.get(i);
        }

        //设置新的选项和答案key
        choiceQuestion.setOption(optionNew);
        choiceQuestion.setKey(questionKeyNew);
    }

}
