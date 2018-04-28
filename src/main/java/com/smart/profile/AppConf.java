package com.smart.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({DevConf.class, TestConf.class})
public class AppConf {
	@Value("${username}")
	private String userName;
	
	@Value("${password}")
	private String password;
	
	@Value("${url}")
	private String url;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}	
	@Bean
	public DataSource dataSource()
	{
		DataSource source = new DataSource();
		source.setUsername(userName);
		source.setPassword(password);
		source.setUrl(url);
		return source;
	}
}
