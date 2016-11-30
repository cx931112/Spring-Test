package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
@RequestMapping(value="/home")
/*  可以返回String类型
    public String index(){
	System.out.println("ok");
	return "index";
}*/
public ModelAndView index(){
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index");
	return mv;
}
}
