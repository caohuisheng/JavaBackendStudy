package com.chs.knife4j;

import com.chs.knife4j.config.PropertySettingInitializer;
import org.springdoc.core.SpringDocConfigProperties;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

@SpringBootApplication
public class Knife4jOpenapi3Application {

    public static void main(String[] args) {
        // System.setProperty("springdoc.swagger-ui.enabled", "false");
        // System.setProperty("springdoc.api-docs.enabled", "false");

        // SpringApplication app = new SpringApplication(Knife4jOpenapi3Application.class);
        // app.addInitializers(new PropertySettingInitializer());
        // app.run(args);
        SpringApplication.run(Knife4jOpenapi3Application.class, args);
    }

}
