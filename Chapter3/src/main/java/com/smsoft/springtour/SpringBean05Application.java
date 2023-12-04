package com.smsoft.springtour;

import com.smsoft.springtour.domain.format.DateFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.swing.plaf.PanelUI;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication
public class SpringBean05Application {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBean05Application.class, args);
        ThreadPoolTaskExecutor taskExecutor = applicationContext.getBean(ThreadPoolTaskExecutor.class);

        final String dateString = "2023-12-04T20:48:00.-08:00";

        for (int i=0; i<100; i++) {
            taskExecutor.submit(() -> {
                try {
                    DateFormatter dateFormatter = applicationContext.getBean("singletonDateFormatter", DateFormatter.class);
                    log.info("Date : {}, hashCode : {}", dateFormatter.parse(dateString), dateFormatter.hashCode());
                } catch (Exception e) {
                    log.error("error to parse", e);
                }
            });
        }
        TimeUnit.SECONDS.sleep(5);
        applicationContext.close();
    }

    @Bean
    @Scope("prototype") // 다시 보고 scope에 대해 이해해보자
    public DateFormatter singletonDateFormatter() {
        return new DateFormatter("yyyy-mm-dd'T'HH:mm:ss");
    }
}
