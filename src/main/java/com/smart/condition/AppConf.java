package com.smart.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class AppConf {

	/**
	 * 被其它bean依赖的实例应该在最前面实例化，condition才会生效
	 * @return
	 */
	/*@Bean
	public DependencyBean db()
	{
		return new DependencyBean();
	}*/
	
	/**
	 * 考虑到@Conditional中的class不一定都是用一个condition来做判断，所以需要添加适配，封装一层Conditional,
	 * 可以再Condition的match中通过AnnotatedTypeMetadata metadata获取入口传入的class type
	 * @return
	 */
	@Bean
	@IfExist(DependencyBean.class)
	public SomeBean someBean()
	{
		return new SomeBean();
	}
	
	
}
