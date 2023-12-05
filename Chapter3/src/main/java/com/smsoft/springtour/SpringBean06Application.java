package com.smsoft.springtour;

import com.smsoft.springtour.domain.lifecycle.LifeCycleComponent;
import com.smsoft.springtour.domain.lifecycle.PrintableBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBean06Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBean06Application.class);
        ctx.close();
    }

    @Bean(initMethod = "init", destroyMethod = "clear")
    public LifeCycleComponent lifeCycleComponent() {
        return new LifeCycleComponent();
    }

    @Bean
    public BeanPostProcessor beanPostProcessor() {
        return new PrintableBeanPostProcessor();
    }
}
