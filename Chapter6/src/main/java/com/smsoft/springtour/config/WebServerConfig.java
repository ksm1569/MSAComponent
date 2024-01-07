package com.smsoft.springtour.config;

import com.smsoft.springtour.controller.converter.HotelRoomNumberConverter;
import com.smsoft.springtour.controller.resolver.ClientInfoArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebServerConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ClientInfoArgumentResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new HotelRoomNumberConverter());
    }
}
