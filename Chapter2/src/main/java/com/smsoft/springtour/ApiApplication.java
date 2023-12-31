package com.smsoft.springtour;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Chapter2Application.class, args);

        Environment env = ctx.getBean(Environment.class);
        String portValue = env.getProperty("server.port");
        log.info("Customized Port : {}", portValue);

        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(name -> log.info("Bean Name : {}", name));
    }
}
