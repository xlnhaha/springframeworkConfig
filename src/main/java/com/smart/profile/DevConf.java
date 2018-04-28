package com.smart.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySource("classpath:dev-prop.properties")
@Profile("dev")
public class DevConf {
	
}
