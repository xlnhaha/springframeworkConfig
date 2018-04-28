package com.smart.webconfig;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

public class WebAppInit implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		//创建applicationContext实例
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConf.class);
		ctx.setServletContext(servletContext);
		//servletContext 注册servlet/filter等
		Dynamic dynamic = servletContext.addServlet("dispatchServlet", new DispatcherServlet(ctx));
		dynamic.addMapping("*.do");
		dynamic.setLoadOnStartup(1);
		
		javax.servlet.FilterRegistration.Dynamic filterDynamic = servletContext.addFilter("encodingFilter", 
				new CharacterEncodingFilter("utf-8", true));
		filterDynamic.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "dispatchServlet");
	}

}
