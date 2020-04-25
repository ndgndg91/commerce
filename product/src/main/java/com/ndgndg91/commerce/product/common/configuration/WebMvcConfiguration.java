package com.ndgndg91.commerce.product.common.configuration;

import com.ndgndg91.commerce.product.common.page.PageableArgumentResolver;
import com.ndgndg91.commerce.product.common.page.PageableRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Bean
    public PageableArgumentResolver pageableArgumentResolver() {
        PageableArgumentResolver resolver = new PageableArgumentResolver();
        resolver.setFallbackPageable(new PageableRequest(0, 5));
        return resolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(pageableArgumentResolver());
    }
}
