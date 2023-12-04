package com.smsoft.springtour;

import com.smsoft.springtour.service.CircularService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CircularApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CircularApplication.class);
        CircularService circularService = ctx.getBean(CircularService.class);
        ctx.close();
    }
}
