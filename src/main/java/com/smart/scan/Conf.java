package com.smart.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan //使用组件扫描的注解生成各种bean,默认扫描被标记的类所在包及其子包的所有类,所以常常将作为主配置对象的类放在根目录下
//@ComponentScan(basePackages="com.smart")
public class Conf {
}
