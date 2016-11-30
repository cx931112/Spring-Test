package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	mv.setViewName("login");
	return mv;
}
//请求参数直接写在方法的参数上能够直接使用,请求方式写在注解里能够实现不同的请求方式相同url的请求到不同的方法里
@RequestMapping(value="toLogin",method=RequestMethod.POST)
public ModelAndView toLogin(String username,String password){
	System.out.println("username:"+username);
	System.out.println("password:"+password);
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index");
	return mv;
}
//使用超链接get请求传过来参数
@RequestMapping(value="toCheck", method=RequestMethod.GET)
public ModelAndView toCheck(String username,String password){
	System.out.println("username:"+username);
	System.out.println("password:"+password);
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index");
	return mv;
}
}
