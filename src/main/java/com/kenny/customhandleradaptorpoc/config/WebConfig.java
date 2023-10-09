package com.kenny.customhandleradaptorpoc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenny.customhandleradaptorpoc.filter.CachingRequestBodyFilter;
import com.kenny.customhandleradaptorpoc.handler.승인HandlerAdapter;
import com.kenny.customhandleradaptorpoc.handler.승인HandlerMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebConfig {

    private final ApplicationContext applicationContext;
    private final ObjectMapper objectMapper;
    private final CachingRequestBodyFilter cachingRequestBodyFilter;

    @Bean
    public 승인HandlerMapping handlerMapping() {
        log.warn("# WebConfig 승인HandlerMapping Bean 등록");

        return new 승인HandlerMapping(applicationContext);
    }

    @Bean
    public 승인HandlerAdapter handlerAdapter() {
        log.warn("# WebConfig 승인HandlerAdapter Bean 등록");

        return new 승인HandlerAdapter(objectMapper);
    }

    @Bean
    public FilterRegistrationBean<CachingRequestBodyFilter> requestFilter() {
        log.warn("# WebConfig CachingRequestBodyFilter Bean 등록");

        final FilterRegistrationBean<CachingRequestBodyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(cachingRequestBodyFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
