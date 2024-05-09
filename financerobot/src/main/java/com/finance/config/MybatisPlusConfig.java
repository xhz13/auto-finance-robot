package com.finance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusPropertiesCustomizer plusPropertiesCustomizer() {
        return plusProperties -> plusProperties.getConfiguration()
                .setMapUnderscoreToCamelCase(false);
    }
}