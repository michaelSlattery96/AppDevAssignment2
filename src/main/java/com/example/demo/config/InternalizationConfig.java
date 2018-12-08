package com.example.demo.config;

import java.util.Locale;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Configuration
public class InternalizationConfig implements WebMvcConfigurer  {

	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver= new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.UK);
		return localeResolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci= new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	// 		<!--  adapted from https://stackoverflow.com/questions/27623405/thymeleaf-add-parameter-to-current-url -->

	@Bean
	public Function<String, String> currentUrlWithoutParam() {
	    return param -> ServletUriComponentsBuilder.fromCurrentRequest().replaceQueryParam(param).toUriString();
	}
	


}