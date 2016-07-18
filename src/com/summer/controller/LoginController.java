package com.summer.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.summer.model.Department;
import com.summer.model.Employee;
import com.summer.service.DepartmentService;
import com.summer.service.EmployeeService;


@Controller
public class LoginController {
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("login.do")
	public ModelAndView login(Employee employee, @RequestParam("type")String type, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        Employee e = employeeService.login(employee);
        
    	if(null==e){
    		mav.setViewName("login");
    		mav.addObject("error","用户名或密码有误");
    		return mav;
    	}
    	else if(e.getIf_manager()==false && type.equals("manager")){
    		mav.setViewName("login");
    		mav.addObject("error","该用户不是管理员");
    		return mav;
    	}
    	else{
			session.setAttribute("employee", e);
	        Department d=departmentService.getDepartmentById(e.getDep_id());
			session.setAttribute("department", d);
    		if(type.equals("manager")){
    			mav.setViewName("jsp/manager/index");
    			return mav;
    		}
        	else {
        		mav.setViewName("jsp/employee/index");
        		return mav;
        	}
    	}
		 
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
    	session.setAttribute("employee",null);
    	session.setAttribute("department",null);
    	
    	mav.setViewName("login");
		return mav;
	}
	
}
