<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
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
	<h2>添加角色</h2>
	<form action="${pageContext.request.contextPath }/role/addRole.action"
		method="post">
		<table width=100% height="500px" bgcolor="black" cellspacing="1px">
			<tr bgcolor="white">
				<td align="center">角色名称</td>
				<td><input type="text" placeholder="请填写角色名称" name="rName"></td>

			</tr>
			<tr bgcolor="white">
				<td align="center">角色描述</td>
				<td><textarea rows="10" cols="80" placeholder="请填写角色描述"
						name="rDesc"></textarea></td>
			</tr>
			


		</table>
		<div>
			<input type="submit" value="保存"> <a
				href="javascript:history.go(-1)">返回</a>

		</div>
	</form>
</body>
</html>