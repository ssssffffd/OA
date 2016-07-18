<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.summer.model.Employee,com.summer.model.Department" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员-修改员工信息</title>
<link href="css.css" type="text/css" rel="stylesheet" media="all" />
<style type="text/css">
</style>
</head>
<body>

<div id="indexfirst">

	<%Employee employee=(Employee)(request.getSession().getAttribute("employee")); %>
	<%Employee old_empl=(Employee)(request.getAttribute("old_empl")); %>
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
		<div class="tit"><h1>修改员工</h1></div>
		<div id="shenfenshibie">
			<font color="red">${error }</font>
			<sform:form action="manager_empl_update.do" modelAttribute="employee" method="post">
				<p>编号&nbsp;<%=old_empl.getId() %><input type="hidden" name="id" value="<%=old_empl.getId() %>"/></p><br/>
				<p>员工姓名&nbsp;<input type="text" name="name" value="<%=old_empl.getName() %>"/>&nbsp;&nbsp;
					密码&nbsp;<input type="text" name="password" value="<%=old_empl.getPassword() %>"/></p><br/>
				<p>部门&nbsp;<input type="text" name="dep_id" value="<%=old_empl.getDep_id() %>"/>&nbsp;&nbsp;</p><br>
				<p>职务&nbsp;<input type="text" name="position" value="<%=old_empl.getPosition() %>"/>&nbsp;&nbsp;</p><br>
				<p>工资&nbsp;<input type="text" name="salary" value="<%=old_empl.getSalary() %>"/>&nbsp;&nbsp;</p><br>
				<p>性别&nbsp;
					<input type="radio" name="sex" value="true" <%if(old_empl.getSex()){%>checked<%} %>>男&nbsp;
					<input type="radio" name="sex" value="false" <%if(!old_empl.getSex()){ %> checked<%} %>>女
				</p><br>
				<p>是否为管理员&nbsp;
					<input type="radio" name="if_manager" value="false" <%if(!old_empl.getIf_manager()){ %> checked<%} %>>否&nbsp;
					<input type="radio" name="if_manager" value="true" <%if(old_empl.getIf_manager()){ %> checked<%} %>>是
				</p><br><p><input type="submit" value="提交修改" style="height:25px;width:80px;margin:20px"/></p>
			</sform:form>	
		</div>
	</div>
	
	
</div>
</body>
</html>