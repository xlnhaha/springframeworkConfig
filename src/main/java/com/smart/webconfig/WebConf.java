package com.smart.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * 使用配置文件替代springmvc的applicationcontext.xml
 * 让主配置类继承WebMvcConfigurerAdapter，是为了添加一些springmvc自己的定制功能，比如自己实现的拦截器等等
 * @author Administrator
 *
 */
@Configuration
@ComponentScan
@EnableWebMvc
public class WebConf extends WebMvcConfigurerAdapter {
	
	/**
	 * 初始化freemarker的配置
	 * @return
	 */
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer()
	{
		FreeMarkerConfigurer fm = new FreeMarkerConfigurer();
		fm.setDefaultEncoding("utf-8");
		fm.setTemplateLoaderPath("/WEB-INF/views/");
		return fm;
	}
	
	/**
	 * 初始化freemarker resolver实例
	 * @return
	 */
	@Bean
	public FreeMarkerViewResolver freeMarkerViewResolver()
	{
		FreeMarkerViewResolver fs = new FreeMarkerViewResolver();
		fs.setExposeSessionAttributes(true);
		fs.setSuffix(".ftl");
		fs.setContentType("text/html;charset=UTF-8");
		return fs;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/hello").setViewName("hello");//凡是请求是hello的，不通过controller，直接返回hello逻辑视图
		registry.addRedirectViewController("/hello", "/home"); //当请求/hello时直接重定向到/home请求
		registry.addStatusController("/private/**", HttpStatus.NOT_FOUND);//当请求是/private/**时，直接返回404
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
