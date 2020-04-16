package com.tistory.ospace.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer   {
    // Request에서 lang파라미터를 인터셉터해서 locale로 설정(1)
    // ex) ?lang=ko_KR
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
    	LocaleChangeInterceptor bean = new LocaleChangeInterceptor();
    	bean.setParamName("lang");
    	return bean;
    }
    
    // 언어 정보를 세션에 저장하여 사용.
    @Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREA);
		return resolver;
	}
    
    // Intercepter 추가
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(localeChangeInterceptor()); // locale 인터셉터(1)
    }
}
