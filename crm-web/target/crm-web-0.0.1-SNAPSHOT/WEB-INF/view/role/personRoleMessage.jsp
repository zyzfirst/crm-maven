<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	text-align: center;
}

input[type="submit"]:hover, input[type="reset"]:hover {
	background-color: blue;
}
</style>

</head>
<body>
	<h2>详细信息</h2>
	
		<table width=100% height="500px" bgcolor="black" cellspacing="1px">
			<tr bgcolor="white">
				<td align="center">角色名称</td>
				<td>${list.r_name}</td>

			</tr>
			<tr bgcolor="white">
				<td align="center">角色描述</td>
				<td>${list.r_desc }</td>
			</tr>
			
			
		</table>
		<div>
				
					<a href="javascript:history.go(-1)">返回</a>

			</div>
	
</body>
</html>