package cn.bugstack.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-17
 */
public class ApiTest {

    private Logger log = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test(){
        Admin admin = new Admin();
        ConfigFileRecorder configFileRecorder = new ConfigFileRecorder();

        configFileRecorder.setConfigFile(new ConfigFile("20241017001","配置内容A=哈哈",new Date(),"林更新"));
        admin.append(configFileRecorder.saveMemo());
        configFileRecorder.setConfigFile(new ConfigFile("20241017002","配置内容A=呵呵",new Date(),"林更新"));
        admin.append(configFileRecorder.saveMemo());
        configFileRecorder.setConfigFile(new ConfigFile("20241017003","配置内容A=嘻嘻",new Date(),"林更新"));
        admin.append(configFileRecorder.saveMemo());
        configFileRecorder.setConfigFile(new ConfigFile("20241017004","配置内容A=嘿嘿",new Date(),"林更新"));
        admin.append(configFileRecorder.saveMemo());

        configFileRecorder.getMemo(admin.undo());
        log.info("历史记录回滚(undo):{}", JSON.toJSONString(configFileRecorder.getConfigFile()));
        configFileRecorder.getMemo(admin.undo());
        log.info("历史记录回滚(undo):{}", JSON.toJSONString(configFileRecorder.getConfigFile()));
        configFileRecorder.getMemo(admin.redo());
        log.info("历史记录前进(redo):{}", JSON.toJSONString(configFileRecorder.getConfigFile()));
        configFileRecorder.getMemo(admin.get("20241017002"));
        log.info("历史记录获取(get):{}", JSON.toJSONString(configFileRecorder.getConfigFile()));
    }

}
