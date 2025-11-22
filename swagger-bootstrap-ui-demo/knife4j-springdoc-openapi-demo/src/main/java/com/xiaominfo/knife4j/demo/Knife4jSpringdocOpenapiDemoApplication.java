package com.xiaominfo.knife4j.demo;

import io.swagger.v3.oas.models.OpenAPI;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.OpenAPIService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.util.Locale;

@SpringBootApplication
public class Knife4jSpringdocOpenapiDemoApplication {
	private static Logger logger= LoggerFactory.getLogger(Knife4jSpringdocOpenapiDemoApplication.class);
	@SneakyThrows
	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(Knife4jSpringdocOpenapiDemoApplication.class);
		ConfigurableApplicationContext application=app.run(args);
		//ConfigurableApplicationContext application=SpringApplication.run(Knife4jSpringBootDemoApplication.class, args);
		Environment env = application.getEnvironment();
		logger.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\thttp://localhost:{}\n\t" +
						"External: \thttp://{}:{}\n\t"+
						"Doc: \thttp://{}:{}/doc.html\n"+
						"----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"));

	}

}
