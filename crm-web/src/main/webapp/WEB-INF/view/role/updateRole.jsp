<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
	<h2>修改角色</h2>
	<form action="${pageContext.request.contextPath }/role/updateRole.action"
		method="post" enctype="multipart/form-data">
		<table width=100% height="500px" bgcolor="black" cellspacing="1px">
			<tr bgcolor="white">
				<td align="center">角色名称</td>
				<td><input type="text" name="r.rName" value="${list.rName }">
				</td>

			</tr>
			<tr bgcolor="white">
				<td align="center">角色描述</td>
				<td><textarea rows="10" cols="80" name="r.rDesc"
						onclick="this.value">${list.rDesc }</textarea></td>
			</tr>
			<tr bgcolor="white">
				<td align="center">修改时间</td>
				<td><input type="datetime-local" name="r.rUpdatetime" 
				value='<fmt:formatDate type="both" pattern="yyyy-MM-dd'T'HH:mm:ss" value="${list.rUpdatetime }" />'>
				</td>
			</tr>
			<tr bgcolor="white">
				<td align="center">添加图片</td>
				<td>
				<input type="file" name="pic" value="${list.rPic }">
                </td>
			</tr>
			 

		</table>
		<div>

			<input type="submit" value="保存"> <input type="hidden"
				name="r.rId" value="${list.rId }"> <a
				href="javascript:history.go(-1)">返回</a>

		</div>
	</form>
</body>
</html>