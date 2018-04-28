package com.smart.condition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConf.class)
public class AppTest {

	/**
	 * 不可以通过@Autowired直接获取SomeBean,因为如果context中没有这个bean，会出现异常
	 * 只可以通过ctx获取某个类型的bean,判断size
	 */
	@Autowired
	private ApplicationContext ctx;
	@Test
	public void testCondition()
	{
		System.out.println(ctx.getBeansOfType(SomeBean.class).size() > 0);
	}
}
