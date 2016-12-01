<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
    function checkUser(){
    alert("进入该方法！");
    var username=document.getElementById("username");
    var password=document.getElementById("password");
    var settings={
    url:'${pageContext.request.contextPath}/toAjax',
    type:'POST',
    dataType:'json',
    data:{'username':document.getElementById('username').value,'password':document.getElementById('password').value},
    success:function(data){
    alert(data.username);
    }
    
    };
    $.ajax(settings);
    }

    </script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
  </head>
  
  <body>
    <h1>SpringMVC实例</h1>
    <form action="${pageContext.request.contextPath}/toLogin" method="POST">
    <div>
    username:<input tyepe="text" name="username" id="username"/>
    </div>
    <div>
    password:<input type="password" name="password" id="password"/>
    </div>
    <input type="submit" value="登录"/>
    <input type="button"  value="检测" id="check" onclick="checkUser()"/>
    </form>
    <a href="${pageContext.request.contextPath}/toCheck?username=cx&password=123">检查一下</a>
  </body>
</html>
