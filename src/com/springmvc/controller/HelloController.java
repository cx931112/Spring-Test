package com.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entity.User;

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
public String toLogin(String username,String password){
	System.out.println("username:"+username);
	System.out.println("password:"+password);
//此处redirect需要写完整的试图名返回String类型后产生一个请求,会进入DispatcherServlet所以需要访问静态资源还需要配置静态资源的访问
	return "redirect:index.jsp";
}
//使用超链接get请求传过来参数,实现转发
@RequestMapping(value="toCheck", method=RequestMethod.GET)
public ModelAndView toCheck(String username,String password){
	System.out.println("username:"+username);
	System.out.println("password:"+password);
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index");
	mv.addObject("username", username);
	mv.addObject("password", password);
	return mv;
}
//方法参数名和请求参数名不同名的时候，用@RequestPrarm()请求参数名即get请求后拼接的参数，和post请求过来的name值属性
@RequestMapping(value="toTest")
public ModelAndView toTest(@RequestParam("username") String name,String password ){
	ModelAndView mv=new ModelAndView();
	mv.setViewName("index");
	return mv;
}

/**
 * 测试对象接收参数

@RequestMapping("test3.do")
public ModelAndView test3(User user){
    System.out.println(user);
    return new ModelAndView("jsp/hello");
}
*/
/**
 * 使用ModelMap传出参数   内部HttpServletRequest的Attribute传递到jsp页面

@RequestMapping("test5.do")
public ModelAndView test5(User user,ModelMap modelMap){
    modelMap.put("user", user);
    return new ModelAndView("jsp/hello");
}
*/
/**
 * 使用@ModelAttribute() 将内部HttpServletRequest的Attribute传递到jsp页面
 * 在Contoller的参数部分或者bean属性方法上使用
@RequestMapping("test6.do")
public ModelAndView test6(@ModelAttribute("user")User user){
    return new ModelAndView("jsp/hello");
}
 */
/**
 * session存储   可以使用HttpServletRequest的getSession方法访问，也能直接在方法里声明HttpSession
@RequestMapping("test7.do")
public ModelAndView test7(HttpServletRequest req){
    HttpSession session = req.getSession();
    session.setAttribute("salary", 6000.0);
    return new ModelAndView("jsp/hello");
}
 */
/**返回String时默认是转发，如果想重定向需写成 return "redirect:test9.do";格式
@RequestMapping("/test8.do")
public String test8(User user, ModelMap model) {
    model.addAttribute("user", user);
    return "jsp/hello";
}*/
/**
 *使用ModelAndView和RedirectView重定向
@RequestMapping("test10")
public ModelAndView test10(User user){
    if(user.getUserName().equals("123")){
        return new ModelAndView("jsp/hello");//test10.do 转发
    }else{
        return new ModelAndView(new RedirectView("test9.do"));//test9.do?age=22 重定向
    }
}
 * @throws IOException 
 */
@RequestMapping(value="toAjax")
public void toAjax(String username,String password,HttpServletResponse response) throws IOException{
	PrintWriter out=response.getWriter();
	User user=new User();
	user.setUsername(username);
	user.setPassword(password);
	//将对象转换成json对象，再将json对象转换成字符串的方法，需要使用到json-lib-*-jdk.jar

	out.write("hello");
/*	
 * 将json字符串转换成对象
 * JSONObject json1=JSONObject.fromObject(jsonString);
	User user1=(User)json1.toBean(json1,User.class);*/
}

}
