<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

</head>
<body>
	<h1>登录</h1>
	<hr>
	<p style="color: red; font: 900"></p>
	<form action="${pageContext.request.contextPath }/login.action" method="post">
		<table border="1">
		<tr>
			<td colspan="1">邮箱：</td> 
			<td colspan="2"> <input type="text" name="email"  /></td>
		</tr>
		<tr>
			<td colspan="1">密 &nbsp;码：</td>
			<td colspan="2"><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="6"><input type="submit" value="登录">
			<input type="reset" value="重置">
		</tr>
		</table>
	</form>
</body>
</html>