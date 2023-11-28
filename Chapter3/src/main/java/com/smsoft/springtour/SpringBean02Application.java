package com.smsoft.springtour;

import com.smsoft.springtour.domain.format.Formatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
public class SpringBean02Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBean02Application.class);

        Formatter<LocalDateTime> formatter = ctx.getBean("localDateTimeFormatter", Formatter.class);
        String date = formatter.of(LocalDateTime.of(2023, 12, 24, 23, 59, 59));

        log.info("Date : " + date);

        ctx.close();
    }
}
