package com.itheima02;

public enum Light2 {
    RED("红"){
        @Override
        public void show() {
            System.out.println("红");
        }
    },YELLOW("黄"){
        @Override
        public void show() {
            System.out.println("黄");
        }
    },GREEN("绿"){
        @Override
        public void show() {
            System.out.println("绿");
        }
    };

    private String name;

    private Light2(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void show();
}
