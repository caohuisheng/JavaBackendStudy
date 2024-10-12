package cn.bugstack.design.door.config;

/**
 * Author: chs
 * Description: 配置服务类
 * CreateTime: 2024-10-12
 */
public class StarterService {

    private String userStr;

    public StarterService(String userStr){
        this.userStr = userStr;
    }

    public String[] split(String separatorChar){
        return this.userStr.split(separatorChar);
    }

}
