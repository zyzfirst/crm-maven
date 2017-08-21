<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="zyz" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
<style type="text/css">
a{
    text-decoration: none;
    color: black;
}
a:hover{
    color: blue;
}
</style>
<script type="text/javascript">
 function delect(){
	 return confirm("确定删除吗?");
 }
</script>

</head>
<body>
<h2>角色管理</h2>
<form action="${pageContext.request.contextPath}/role/role.action" method="post">
搜索内容:<input type="text" name="key" placeholder="请输入搜索关键字" value="${key }">
搜索字段:<select name="field" >
            <option value="r_name" ${field eq "r_name"?"selected":"" }>角色名称</option>
            <option value="r_desc" ${field eq "r_desc"?"selected":"" }>角色描述</option>
          </select>
<input type="submit"  value="搜索">
</form>

<a target="pageBox" href="${pageContext.request.contextPath}/role/addRole.action" style="float: right; margin-right: 30px">添加角色</a>
<form action="${pageContext.request.contextPath}/role/multieditRole.action">
<table width="100%" height="300px" bgcolor="black" cellspacing="1px">
<tr bgcolor="white">
  <th>序号</th>
  <th>角色名称</th>
  <th>角色描述</th>
  <th>更新时间</th>
  <th>头像</th>
  <th>操作</th>
</tr>
<c:forEach items="${page.rows }" var="li" varStatus="status">
			
			<tr bgcolor="white">
			  <td>${status.count }</td>
			  <td>
			  <input type="text" value="${li.rName }" name="list[${status.index}].rName">
			  </td>
			  
			  <td>
			  <input type="text" value="${li.rDesc }" name="list[${status.index}].rDesc">
			  </td>
			  <td>
			  
			  <fmt:formatDate value="${li.rUpdatetime }" type="both" pattern="yyyy-MM-dd HH:mm"/>
			  
			  </td>
			  <td>
			  <img alt="" src="/pic/${li.rPic }" width="30px" height="30px">
			  </td>
			  
			  <td>
			   <a href="${pageContext.request.contextPath}/role/updateRole.action?id=${li.rId}"  class="fa fa-pencil" title="修改" ></a>
               <a href="${pageContext.request.contextPath}/role/deleteRole.action?id=${li.rId}" class="fa fa-remove" title="删除" onclick="return delect()"></a>

			  </td>
			  
			
			</tr>
			
			<input type="hidden" name="list[${status.index}].rId" value="${li.rId }">
			</c:forEach>

</table>
<input type="submit">
</form>
<zyz:page url="${pageContext.request.contextPath }/role/role.action"></zyz:page>
</body>
</html>