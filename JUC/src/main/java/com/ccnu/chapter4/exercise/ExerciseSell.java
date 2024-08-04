package com.ccnu.chapter4.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Author: chs
 * Description: 买票练习
 * CreateTime: 2024-08-03
 */
@Slf4j
public class ExerciseSell {

    //Random为线程安全的
    static Random random = new Random();
    private static int randomAmount(){
        return random.nextInt(5) + 1;
    }

    public static void main(String[] args) {
        //创建一个包含2000张票的窗口
        TicketWindow window = new TicketWindow(2000);

        List<Thread> list = new ArrayList<>();
        //记录每次买的票数量
        List<Integer> sellCount = new Vector<>();
        for (int i = 0; i < 2000; i++) {
            Thread thread = new Thread(() -> {
                int count = window.sell(randomAmount());
                sellCount.add(count);
            });
            thread.start();
        }

        list.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        int totalCount = sellCount.stream().mapToInt(c -> c).sum();
        log.info("selledCount=" + totalCount + " remainCount=" + window.getCount());
    }

    static class TicketWindow{
        private int count;

        public TicketWindow(int count){
            this.count = count;
        }

        public int getCount(){
            return this.count;
        }

        public int sell(int amount){
            if(this.count >= amount){
                this.count -= amount;
                return amount;
            }else{
                return 0;
            }
        }
    }
}
