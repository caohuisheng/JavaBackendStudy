package cn.bugstack.design;

/**
 * Author: chs
 * Description: 问答题
 * CreateTime: 2024-10-06
 */
public class AnswerQuestion {

    private String name;
    private String key;

    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
