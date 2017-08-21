<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
异常是:${obj}
原因是:${exception.message }
<img alt="" src="${pageContext.request.contextPath }/image/1.jpg" width="100%" height="100%">
</body>
</html>