package com.smart.imports;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Conf.class)
public class AppTest {
	@Autowired
	private DataSource ds;
	
	@Autowired
	private RedisResource rs;
	
	@Autowired
	private SomeBean someBean;
	@Test
	public void test()
	{
		System.out.println(ds);
		System.out.println(rs);
		System.out.println(someBean.getOtherBean());
	}
}
