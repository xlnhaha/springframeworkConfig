package com.smart.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Scope;

//默认单例模式
@Scope("singleton")
@Getter
@Setter
public class SomeBean {
	
	private OtherBean otherbean;
	
	/**
	 *@PostConstruct 声明bean的init方法，可以替代@Bean(initMethod="init", destroyMethod="destory")
	 */
	//@PostConstruct
	public void  init()
	{
		System.out.println("init somebean");
	}
	
	//@PreDestroy(等同于@Bean(destroyMethod="destory"))
	public void destory()
	{
		System.out.println("destory somebean");
	}
}
