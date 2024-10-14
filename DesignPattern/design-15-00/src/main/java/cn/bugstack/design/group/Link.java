package cn.bugstack.design.group;

/**
 * Author: chs
 * Description: 链接
 * CreateTime: 2024-10-14
 */
public class Link {

    private String from;
    private String to;

    public Link(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
