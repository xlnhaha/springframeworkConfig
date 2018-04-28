package com.smart.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class MyConditional implements Condition{

	/**
	 * 可以通过context获取当前上下文环境，查看某个类是否被实例化，用以自动适配环境等
	 * false,则注解为此Condition的bean不实例化
	 * true,则注解为此Condition的bean会实例化
	 */
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
		// 获取Conditional注解入口的class type
		MultiValueMap<String, Object> multiMap = metadata.getAllAnnotationAttributes(IfExist.class.getName());
		// 遍历multiMap,在context中如果可以获得任意一个的bean,返回true,否则false
		for(Object obj : multiMap.get("value"))
		{
			if (context.getBeanFactory().getBeansOfType((Class<?>)obj).size() > 0)
			{
				return true;
			}
		}
		return false;
	}

}
