<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
text-align: center;

}

input[type="submit"]:hover,input[type="reset"]:hover {
	background-color: blue;
}
</style>
</head>
<body>
	<h3 align="left">新增用户</h3>
	<form action="${pageContext.request.contextPath }/updateUser.action" method="post" enctype="multipart/form-data">
	<table width=100% height="500px" bgcolor="black" cellspacing="1px" >

		<tr bgcolor="white">
			<td align="center">用户名</td>
			<td><input type="text" placeholder="请填写用户名" name="uName" value="${list.uName }">
			</td>
			</tr>
			<tr bgcolor="white">
			<td align="center">密码</td>
			<td><input type="password" name="uPwd" value="${list.uPwd }">
			</td>
		</tr>
		<tr bgcolor="white">
		<td align="center">头像</td>
		<td>
		 <input type="file" name="pic">
		</td>
		</tr>
	</table>
	
	<div>
	<input type="hidden" name="uId" value="${list.uId }">
	 <input type="submit" value="保存">
	 <a href="javascript:history.go(-1)">返回</a>

	 </div>
	
	</form>
</body>
</html>