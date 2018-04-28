package com.smart.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConf.class)
@ActiveProfiles("test") // 或者可以在环境变量或者jvm启动设置spring.profiles.active或者spring.profiles.default
public class AppTest {
	@Autowired
	private DataSource ds;
	
	@Test
	public void dsInit()
	{
		System.out.println(ds.toString());
	}
}
