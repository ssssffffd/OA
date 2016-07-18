<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.summer.model.Employee,com.summer.model.Department,java.util.*" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员-添加员工</title>
<link href="css.css" type="text/css" rel="stylesheet" media="all" />
<style type="text/css">
</style>
</head>
<body>

<div id="indexfirst">

	<%Employee employee=(Employee)(request.getSession().getAttribute("employee")); %>
	<div id="topmenu"><img src="images/banner.gif" width="970" height="147" /></div><p></p><p></p>
	<br/><br/><br/><div id="place">
		你好：管理员<%=employee.getName() %><br/><br/>
		<a href="dep_list.do">[显示部门]</a><br/><br/>
		<a href="dep_add_view.do">[添加部门]</a><br/><br/>
		<a href="empl_add_view.do">[添加员工]</a><br/><br/>
		<a href="empl_list.do">[显示员工]</a><br/><br/>
		<a href="empl_search_view.do">[查询员工]</a><br/><br/>
		<a href="logout.do">[注销]</a>
	</div>
	<div id="menunav2">
		<div class="tit"><h1>添加员工</h1></div>
		<div id="shenfenshibie" >
			<font color="red">${error }</font>
			<sform:form action="empl_add.do" modelAttribute="employee" method="post">
				<p>名字&nbsp;<input type="text" name="name"/>&nbsp;&nbsp;
					密码&nbsp;<input type="text" name="password" value="123"></p><br>
				<p>部门编号&nbsp;<input type="text" name="dep_id" value="1"></p><br>
				<p>职务&nbsp;<input type="text" name="position">&nbsp;&nbsp;
					工资&nbsp;
					<input type="radio" name="salary" value="3000" checked>3k&nbsp;
					<input type="radio" name="salary" value="6000" >6k&nbsp;
					<input type="radio" name="salary" value="10000" >10k&nbsp;
					<input type="radio" name="salary" value="15000" >15k&nbsp;
				</p><br>
				<p>性别&nbsp;
					<input type="radio" name="sex" value="true" checked>男&nbsp;
					<input type="radio" name="sex" value="false">女
				</p><br>
				<p>是否为管理员&nbsp;
					<input type="radio" name="if_manager" value="false" checked>否&nbsp;
					<input type="radio" name="if_manager" value="true">是
				</p><br>
				<p><input type="submit" value="添 加" style="height:25px;width:80px;margin:20px"/></p>
			</sform:form>	
		</div>
	</div>
	
	
</div>
</body>
</html>