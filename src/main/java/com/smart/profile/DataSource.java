package com.smart.profile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class DataSource {
	private String username;
	private String password;
	private String url;
}
