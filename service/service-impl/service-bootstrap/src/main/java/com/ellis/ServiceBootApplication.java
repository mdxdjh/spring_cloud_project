package com.ellis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 服务启动类
 */
@SpringBootApplication(scanBasePackages = "com.ellis")
@Configuration
@EnableAutoConfiguration
@ImportResource(locations = { "classpath:spring-main.xml" })
public class ServiceBootApplication extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServiceBootApplication.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(ServiceBootApplication.class, args);
    }
}
