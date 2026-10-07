package com.itheima.pojo;

public class User {
    private int id;
    private String userName;
    private String password;
    private String gender;
    private String addr;

    public User(int id, String userName, String password, String gender, String addr) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
