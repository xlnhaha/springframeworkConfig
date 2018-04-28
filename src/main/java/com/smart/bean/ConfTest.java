package com.smart.bean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfTest {
	
	/**
	 * 使用xml管理bean
	 */
	//@Test
	/*public void getBean()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		SomeBean bean = ctx.getBean(SomeBean.class);
		System.out.println(bean);
		Assert.assertNotNull(bean);
	}*/
	
	/**
	 * 使用注解管理bean
	 */
	@Test
	public void getBean()
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Conf.class);
		SomeBean bean = ctx.getBean(SomeBean.class);
		System.out.println(bean);
		System.out.println(bean.getOtherbean().getName());
		//关闭applicationcontext
		//因为AnnotationConfApplicationContext实现了Closeable接口，所有可以将上面代码用try{}包围，在执行完后会自动调用finally,并关闭资源
		ctx.close();
	}
}
