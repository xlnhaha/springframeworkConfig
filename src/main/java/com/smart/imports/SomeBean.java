package com.smart.imports;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class SomeBean {
	@Autowired
	private OtherBean otherBean;
}
