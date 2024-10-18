package cn.bugstack.design;

/**
 * Author: chs
 * Description: 配置文件备忘录（相当于是对原有配置文件的扩展）
 * CreateTime: 2024-10-17
 */
public class ConfigFileMemo {

    private ConfigFile configFile;

    public ConfigFileMemo(ConfigFile configFile){
        this.configFile = configFile;
    }

    public ConfigFile getConfigFile(){
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile){
        this.configFile = configFile;
    }

}
