package cn.bugstack.design;

import java.util.Map;

/**
 * Author: chs
 * Description: 选择题
 * CreateTime: 2024-10-06
 */
public class ChoiceQuestion {

    private String name;
    private Map<String, String> option;
    private String key;

    public ChoiceQuestion(String name, Map<String, String> option, String key) {
        this.name = name;
        this.option = option;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getOption() {
        return option;
    }

    public void setOption(Map<String, String> option) {
        this.option = option;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
