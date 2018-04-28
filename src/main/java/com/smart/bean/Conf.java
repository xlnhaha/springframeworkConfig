package com.smart.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class Conf {
	
	
	/**
	 * 内部bean方式配置属性
	 * <bean>
	 * 	<property>
	 * 		<bean class=""/>
	 *  </property>
	 * </bean>
	 * @return
	 */
	/*@Bean(name="sb",initMethod="init", destroyMethod="destory")
	public SomeBean getBean()
	{
		SomeBean somebean = new SomeBean();
		somebean.setOtherbean(new OtherBean());
		return somebean;
	}
	
	*//**
	 * 方法2， 直接调用方法注入
	 * @return
	 *//*
	@Bean
	public SomeBean someBean1()
	{
		SomeBean somebean = new SomeBean();
		// 可以直接调用方法，生成单例的otherbean
		somebean.setOtherbean(otherBean());
		return somebean;
	}*/
	
	/**
	 * 方法3 直接参数依赖
	 * 如果参数对应不同的bean,则需要用@Qualifier("bean name")来区别注入的是什么对象
	 * 或者参数名字用来确定注入的bean public SomeBean someBean(OtherBean otherBean1)
	 * <bean>
	 * 	<property name="" value="${db.url}"/>
	 *  <property name="" ref="beanId"/>
	 * </bean>
	 * @return
	 */
	@Bean
	public SomeBean someBean(@Qualifier("otherBean1") OtherBean otherBean)
	{
		SomeBean somebean = new SomeBean();
		somebean.setOtherbean(otherBean);
		return somebean;
	}
	@Bean
	//@Primary //首选bean,相同class有多个bean,设定优先
	public OtherBean otherBean()
	{
		return new OtherBean();
	}
	
	/**
	 *  注入<property name="" value=""/>
	 *  相对后一种environmen的方法，推荐这个方法，因为value可以是各种类型，env只可以返回String
	 */
	/*
	@Value("${other.name}")
	private String name;
	*/
	/**
	 * 加载properties,除使用@Value外，可以使用Environment,spring的环境，它包括两个部分的内容：
	 * 1 properties
	 * 2 profile
	 */
	@Autowired
	private Environment env;
	//使用PropertySourcesPlaceholderConfigurer来处理占位符的替换，在bean初始化前，加载后
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public OtherBean otherBean1()
	{
		OtherBean otherBean =  new OtherBean();
		//otherBean.setName(name);
		otherBean.setName(env.getProperty("other.name"));
		return otherBean;
	}
}
