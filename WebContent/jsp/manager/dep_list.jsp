<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.summer.model.Employee,com.summer.model.Department" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员-显示部门</title>
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
		<div class="tit"><h1>部门信息</h1></div>
		<div id="shenfenshibie">
			<font color="red">${error }</font>
			<table  width="100%" cellspacing="20">
				<tr><td>编号</td><td>部门名字</td><td>主管ID</td><td></td></tr>
				<c:forEach items="${requestScope.dep_list }" var="dep">
					<tr><td>${dep.id }</td>
						<td><a href="dep_empl_list.do?dep_id=${dep.id }">${dep.name }</a></td>
						<td><a href="manager_empl_update_view.do?id=${dep.leader_id }">${dep.leader_id }</a></td>
						<td><a href="dep_update_view.do?dep_id=${dep.id }">[修改]</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	
</div>
</body>
</html>