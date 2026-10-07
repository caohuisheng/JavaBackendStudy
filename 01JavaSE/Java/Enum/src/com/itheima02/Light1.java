package com.itheima02;

public enum Light1 {
    RED("红"),YELLOW("黄"),GREEN("绿");

    private String name;

    private Light1(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
