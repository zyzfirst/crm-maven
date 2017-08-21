<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
<style type="text/css">
a {
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
<h2>用户管理</h2>
<form action="${pageContext.request.contextPath}/seekUser" method="post">
搜索内容:<input type="text" name="key" placeholder="请输入搜索关键字" value="${key }">
搜索字段:<select name="field" >
            <option value="u_name" ${field eq "u_name"?"selected":"" }>用户名</option>
            <option value="u_hobby" ${field eq "u_hobby"?"selected":"" }>爱好</option>
            <option value="u_edu" ${field eq "u_edu"?"selected":"" }>学历</option>
            <option value="u_nation" ${field eq "u_nation"?"selected":"" }>民族</option>
            <option value="u_phone" ${field eq "u_phone"?"selected":"" }>手机号</option>
            <option value="u_address" ${field eq "u_address"?"selected":"" }>地址</option>
            
         </select>
<input type="submit"  value="搜索">
</form>
<a target="pageBox" href="${pageContext.request.contextPath}/jumpAddUser" style="float: right; margin-right: 30px">添加用户</a>
<table width="100%" height="300px" bgcolor="black" cellspacing="1px">
<tr bgcolor="white">
  <th>序号</th>
  <th>用户名</th>
  <th>部门</th>
  <th>角色</th>
  <th>手机号</th>
  <th>邮箱</th>
  <th>更新时间</th>
  <th>操作</th>
</tr>
<c:forEach items="${list}" var="li" varStatus="status">
<tr bgcolor="white">

    <td>${status.count+(pageInfo.currentPage-1)*2 }</td>
    <td><a href="<c:url value="/personUser?id=${li.u_id }" />">${li.u_name }</a></td>
    
    <td>${li.d_name }</td>
    <td>${li.r_name }</td>
    <td>${li.u_phone }</td>
    <td>${li.u_mail }</td>
    <td>
    
        <fmt:formatDate value="${li.u_updatetime }" type="both" pattern="yyyy-MM--dd HH:mm"/>
    
    </td>
    <td>
      <a href="${pageContext.request.contextPath}/findUser?id=${li.u_id}"  class="fa fa-pencil" title="修改" ></a>
      <a href="${pageContext.request.contextPath}/deleteUser?id=${li.u_id}" class="fa fa-remove" title="删除" onclick="return delect()"></a>
    </td>

</tr>
</c:forEach>
</table>




</body>
</html>