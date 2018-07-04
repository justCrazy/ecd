<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信访</title>
<link href="./css/foreground/index.css" rel="stylesheet" type="text/css">
</head>
<body>
hahahah
<h1>登录</h1>
	<form action="loginPerson.action" method="post">
		email：<input type="text" name="email" />
		密 &nbsp;码：<input type="password" name="password"/>
		<input type="submit" value="登录">
			<input type="reset" value="重置">
	</form>
</body>
</html>
