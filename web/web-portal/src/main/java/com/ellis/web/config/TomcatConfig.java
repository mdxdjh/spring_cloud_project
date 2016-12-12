package com.ellis.web.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ellis.luo
 * @date 16/12/12 下午11:47
 * @description
 */
@Configuration
public class TomcatConfig
{
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer()
    {
        return new EmbeddedServletContainerCustomizer()
        {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container)
            {
                container.setPort(8082);
                container.setContextPath("/api");
            }
        };
    }
}
