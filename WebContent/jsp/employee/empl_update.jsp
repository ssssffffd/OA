<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.summer.model.Employee,com.summer.model.Department" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>员工-修改个人信息</title>
<link href="css.css" type="text/css" rel="stylesheet" media="all" />
<style type="text/css">
</style>
</head>
<body>

<div id="indexfirst">

	<%Employee employee=(Employee)(request.getSession().getAttribute("employee")); %>
	<%Department department=(Department)(request.getSession().getAttribute("department")); %>
	<div id="topmenu"><img src="images/banner.gif" width="970" height="147" /></div><p></p><p></p>
	<br/><br/><br/><div id="place">
		你好：<%=employee.getName() %><br/><br/>
		<a href="empl_update_view.do">[修改个人信息]</a><br/><br/>
		<a href="logout.do">[注销]</a>
	</div>
	<div id="menunav2">
		<div class="tit"><h1>修改个人信息</h1></div>
		<div id="shenfenshibie">
			<sform:form action="empl_update.do" modelAttribute="employee" method="post">
				<p>名字&nbsp;<input type="text" name="name" value="<%=employee.getName()%>"/>&nbsp;&nbsp;
					密码&nbsp;<input type="text" name="password" value="<%=employee.getPassword()%>"></p><br>
				<p>部门：<%=department.getName()%></p><br/>
				<p>职务：<%=employee.getPosition()%></p><br/>
				<p>工资：<%=employee.getSalary()%></p><br/>
				<p>性别：<%=employee.getSex()?"男":"女"%></p><br/>	
				<p><input type="submit" value="提交修改" style="height:25px;width:80px;margin:20px"/></p>
			</sform:form>	
		</div>
	</div>
	
</div>
</body>
</html>