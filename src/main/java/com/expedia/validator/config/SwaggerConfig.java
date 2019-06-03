package com.expedia.validator.config;

import io.swagger.jaxrs.config.BeanConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    /**
     * Swagger Configuration
     * @return beanConfig
     */
    @Bean
    public BeanConfig swaggerConfiguration() {
        final BeanConfig beanConfig = new BeanConfig();
        beanConfig.setResourcePackage("com.expedia.validator.services");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
        return beanConfig;
    }
}
