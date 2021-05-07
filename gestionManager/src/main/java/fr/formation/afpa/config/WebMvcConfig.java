package fr.formation.afpa.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import fr.formation.afpa.Interceptor.LogInterceptor;



@Configuration
@EnableWebMvc
public class WebMvcConfig  extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  registry.addResourceHandler("/css/**").addResourceLocations("WEB-INF/resources/CSS/")
	       .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
		  registry.addResourceHandler("/js/**").addResourceLocations("WEB-INF/resources/js/");
		  registry.addResourceHandler("/img/**").addResourceLocations("WEB-INF/resources/Images/");
		  registry.addResourceHandler("/include/**").addResourceLocations("WEB-INF/resources/Include/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new LogInterceptor()).addPathPatterns("/*");
		LocaleChangeInterceptor localInterceptor = new LocaleChangeInterceptor();
		localInterceptor.setParamName("lang");
		registry.addInterceptor(localInterceptor).addPathPatterns("/*");

	
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
