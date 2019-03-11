package com.training.springcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@ComponentScan("com.training.springcore")
@Configuration
@PropertySource("classpath:application.properties")
public class BigCorpApplicationConfig {


}
