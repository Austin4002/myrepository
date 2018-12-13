<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	<h1>登录成功</h1>
	<form action="UpdateServlet" method="post">
		<table>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list}" var="stu">
				<tr>
					<td>${stu.id}</td>
					<td>${stu.name}</td>
					<td>${stu.sex}</td>
					<td><a href="DeleteServlet?id=${stu.id}">删除</a> </td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<hr>
	<a href="insert.jsp">添加用户</a><br/>
	<a href="Update.jsp">更新数据</a>
</body>
</html>