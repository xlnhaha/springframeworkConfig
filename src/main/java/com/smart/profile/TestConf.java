package com.smart.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dev-prop.properties")
@Profile("test")
public class TestConf {

}
