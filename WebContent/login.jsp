<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css.css" type="text/css" rel="stylesheet" media="all" />
<title>登录</title>
</head>
<body>

<div id="indexfirst">
	<div id="topmenu"><img src="images/banner.gif" width="970" height="147" /></div><p></p><p></p>
	<br/><br/><br/><br/>
	<%--<div id="menunav2" > --%>
		<div align="center">
		<div class="tit"><h1>
			<font color="red">${error }</font>
			<sform:form action="login.do" modelAttribute="employee" method="post">
				<p>编号&nbsp;<input type="text" name="id"/></p><br>
				<p>密码&nbsp;<input type="password" name="password"/></p><br>
				<p><input type="radio" name="type" value="employee" checked>员工&nbsp;
				<input type="radio" name="type" value="manager">管理员
				<input type="submit" value="登 录" style="height:25px;width:80px;margin:20px"/></p>
			</sform:form>
		</h1></div>
		</div>
</div>

</body>
</html>