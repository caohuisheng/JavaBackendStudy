package cn.bugstack.design.domain;

/**
 * Author: chs
 * Description: 活动库存
 * CreateTime: 2024-10-13
 */
public class Stock {

    private int total;  //库存总量
    private int used;   //库存已用

    public Stock(int total, int used) {
        this.total = total;
        this.used = used;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }
}
