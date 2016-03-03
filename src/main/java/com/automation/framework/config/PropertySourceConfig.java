package com.automation.framework.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {
        "classpath:properties/${envTarget}.webdriver.properties"
})
public class PropertySourceConfig {


	@Bean
    public static PropertySourcesPlaceholderConfigurer getProperties() throws IOException {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
