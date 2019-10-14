package com.monitoring.ui.web.rest.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

//@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    /**
     * Unregister the default {@link StringHttpMessageConverter} as we want Strings
     * to be handled by the JSON converter.
     *
     * @param converters List of already configured converters
     * @see WebMvcConfigurationSupport#addDefaultHttpMessageConverters(List)
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream()
                .filter(c -> c instanceof StringHttpMessageConverter)
                .findFirst().ifPresent(converters::remove);
    }
}