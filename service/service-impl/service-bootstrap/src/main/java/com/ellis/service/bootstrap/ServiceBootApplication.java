package com.ellis.service.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

/**
 * 服务启动类
 */
@SpringBootApplication(scanBasePackages = {"com"})
//@ImportResource(locations = {"classpath:spring-main.xml"})
@EnableDiscoveryClient
public class ServiceBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBootApplication.class, args);
//        new SpringApplicationBuilder(ServiceBootApplication.class).web(false).run(args);
    }
}
