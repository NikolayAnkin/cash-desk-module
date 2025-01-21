package com.cashdeskmodule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cashdeskmodule.handler.CustomHeaderHandlerInterceptor;

@Configuration
@PropertySource("classpath:customheader.properties")
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomHeaderHandlerInterceptor());
	}
}
