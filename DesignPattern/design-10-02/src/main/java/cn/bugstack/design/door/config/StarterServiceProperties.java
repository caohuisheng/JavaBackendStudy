package cn.bugstack.design.door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: chs
 * Description: 配置类注解定义
 * CreateTime: 2024-10-12
 */
@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr(){
        return userStr;
    }

    public void setUserStr(String userStr){
        this.userStr = userStr;
    }

}
