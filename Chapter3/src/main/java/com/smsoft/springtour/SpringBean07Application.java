package com.smsoft.springtour;

import com.smsoft.springtour.domain.PriceUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Locale;

@Slf4j
@SpringBootApplication
public class SpringBean07Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBean07Application.class);
        PriceUnit priceUnit = ctx.getBean(PriceUnit.class);
        log.info("Locale in PriceUnit : {}", priceUnit.getLocale().toString());
        ctx.close();
    }

    @Bean
    @Primary
    public PriceUnit primaryPriceUnit() {
        return new PriceUnit(Locale.US);
    }

    @Bean
    public PriceUnit secondaryPriceUnit() {
        return new PriceUnit(Locale.KOREA);
    }
}
