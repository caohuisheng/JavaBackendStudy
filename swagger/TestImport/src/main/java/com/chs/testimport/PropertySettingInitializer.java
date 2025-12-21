package com.chs.testimport;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * @author chs
 * @date 2025-12-16 13:26
 * @description todo
 */
public class PropertySettingInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public PropertySettingInitializer(){
        System.out.println("PropertySettingInitializer#constructor====");
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // System.setProperty("springdoc.swagger-ui.enabled", "false");
        // System.setProperty("springdoc.api-docs.enabled", "false");

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String swaggerEnabled = environment.getProperty("springdoc.api-docs.enabled");
        System.out.println("PropertySettingInitializer#initialize, swaggerEnabled="+swaggerEnabled);
        if(StringUtils.isEmpty(swaggerEnabled)){
            Properties props = new Properties();
            props.setProperty("springdoc.swagger-ui.enabled", "false");
            props.setProperty("springdoc.api-docs.enabled", "false");
            PropertiesPropertySource pps = new PropertiesPropertySource("earlyProps", props);
            environment.getPropertySources().addFirst(pps);
        }

        MutablePropertySources propertySources = environment.getPropertySources();
        for (PropertySource<?> source : propertySources) {
            // Process each property source
            System.out.println("Source name: " + source.getName());
        }
    }
}
