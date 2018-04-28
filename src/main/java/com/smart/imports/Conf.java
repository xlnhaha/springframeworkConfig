package com.smart.imports;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({RedisResourceConf.class,DataSourceConf.class})//集成一个或多个Configuration
@ImportResource({"classpath:application-context.xml"}) //引入context.xml的配置文件管理bean
public class Conf {

}
