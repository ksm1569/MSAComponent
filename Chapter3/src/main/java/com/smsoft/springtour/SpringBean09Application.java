package com.smsoft.springtour;

import com.smsoft.springtour.domain.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.Locale;

@Slf4j
@SpringBootApplication
public class SpringBean09Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBean09Application.class);
        log.info("-------- Done to initialize spring beans");
        PriceUnit priceUnit = ctx.getBean("lazyPriceUnit", PriceUnit.class);
        log.info("Locale in PriceUnit : {}", priceUnit.getLocale().toString());
        ctx.close();
    }

    @Bean
    @Lazy
    public PriceUnit lazyPriceUnit() {
        // 원래는 스프링컨테이너가 올라올때 호출되는데, Lazy를 붙이면 의존성 주입될때 호출된다.
        log.info("initialize lazyPriceUnit");
        return new PriceUnit(Locale.US);
    }
}
