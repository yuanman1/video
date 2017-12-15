<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误页面</title>
</head>
<body>
出错了<br>
<img alt="图片" src="${pageContext.request.contextPath }/static/img/error.jpg">
异常位置：${obj}<br>
异常信息 ：${error.message }
</body>
</html>