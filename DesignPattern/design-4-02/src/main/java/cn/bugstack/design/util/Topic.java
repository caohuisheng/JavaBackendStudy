package cn.bugstack.design.util;

import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-06
 */
public class Topic {

    //选项
    private Map<String, String> option;
    //答案
    private String key;

    public Topic(Map<String, String> option, String key) {
        this.option = option;
        this.key = key;
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
