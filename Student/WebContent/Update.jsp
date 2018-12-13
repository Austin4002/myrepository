<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生信息</title>
</head>
<body>
	<h1>更新学生信息</h1>
	<form action="UpdateServlet" method="post">

		请输入原学号:<input type="text" name="oid" required="true" /><br /> 
		请输入新学号:<input type="text" name="id" /><br /> 姓名:<input type="text" name="name" /><br />
		性别:<input type="radio" name="sex" value="男" checked="checked" />男
		 <input type="radio" name="sex" value="女" />女<br /> 密码：
		 <input type="password" name="password" /><br /> <input type="submit" value="提交" /><br/>
		 <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回主页">
	</form>

</body>
</html>