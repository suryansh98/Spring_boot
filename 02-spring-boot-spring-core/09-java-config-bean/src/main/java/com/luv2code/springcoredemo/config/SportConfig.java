package com.luv2code.springcoredemo.config;


import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")//now the bean id is aquatic
    public Coach swimCoach(){//bean id is method name if no bean id is given

        return new SwimCoach();
    }
}
