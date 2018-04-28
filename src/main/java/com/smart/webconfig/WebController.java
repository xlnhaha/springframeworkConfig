package com.smart.webconfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
	
	@RequestMapping("/sayHello")
	public String sayHello(Model model)
	{
		model.addAttribute("msg", "hello");
		System.out.println("hello");
		return "hello";
	}
	
	
	@RequestMapping("/addData")
	@ResponseBody
	public String addData(UserInfo userInfo, Model model)
	{
		System.out.println(userInfo.toString());
		model.addAttribute("msg", "good");
		return "hello";
	}
}
