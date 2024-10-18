package cn.bugstack.design;

/**
 * Author: chs
 * Description: 记录者类（获取和返回备忘录类对象信息）
 * CreateTime: 2024-10-17
 */
public class ConfigFileRecorder {

    private ConfigFile configFile;

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public ConfigFileMemo saveMemo(){
        return new ConfigFileMemo(configFile);
    }

    public void getMemo(ConfigFileMemo memo){
        this.configFile = memo.getConfigFile();
    }

}
