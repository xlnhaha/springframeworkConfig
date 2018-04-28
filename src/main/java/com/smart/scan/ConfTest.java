package com.smart.scan;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Conf.class)
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
	//@Test
	/*public void getBean()
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Conf.class);
		SomeBean bean = ctx.getBean(SomeBean.class);
		System.out.println(bean);
		System.out.println(bean.getOtherbean());
		//关闭applicationcontext
		//因为AnnotationConfApplicationContext实现了Closeable接口，所有可以将上面代码用try{}包围，在执行完后会自动调用finally,并关闭资源
		ctx.close();
	}*/
	
	@Autowired
	private SomeBean someBean;
	
	@Test
	public void getBeanTest()
	{
		System.out.println(someBean.getOtherbean());
	}
}
