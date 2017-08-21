<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>登录 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="css/index.css">
<style type="text/css">


</style>
</head>
<body>
	<div class="login">
        <img src="image/logo.png" alt="智游">
        <p>智游客户关系管理系统</p>
        <form action="${pageContext.request.contextPath}/login.action" method="post">
            <div>
                <input type="text" id="username" name="username"  placeholder="请输入用户名" value="admin">
            </div>
            <div>
                <input type="password" id="password" name="password" placeholder="请输入密码" value="admin">
            </div>
            
               <c:if test="${result == 1 }"><div style="text-align: center;color: gray;">"用户名或密码错误"</div></c:if>
            
            <div>
                <input type="checkbox" name="autologin" value="auto" >自动登陆
                <input type="submit" value="登录">
            </div>
        </form>
    </div>
</body>
</html>