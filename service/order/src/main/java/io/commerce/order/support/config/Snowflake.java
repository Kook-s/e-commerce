package io.commerce.order.support.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Snowflake {

    @Bean
    public Snowflake snowflake() {
        return new Snowflake();
    }
}
