package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
@RequestMapping(value="home")
public String index(){
	System.out.println("ok");
	return "index";
}
}
