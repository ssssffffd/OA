package com.summer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.summer.model.Employee;
import com.summer.service.DepartmentService;
import com.summer.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("empl_add_view.do")
	public ModelAndView empl_add_view(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("jsp/manager/empl_add");
		return mav;
	}

	@RequestMapping("empl_add.do")
	public ModelAndView empl_add(Employee employee){
		ModelAndView mav=new ModelAndView();
		if(employeeService.add(employee)==false){
			mav.addObject("error", "部门编号"+employee.getDep_id()+"不存在");
			mav.setViewName("jsp/manager/empl_add");
			return mav;
		}
		mav.setViewName("jsp/manager/index");
		return mav;
	}

	@RequestMapping("empl_update_view.do")
	public ModelAndView empl_update_view(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("jsp/employee/empl_update");
		return mav;
	}
	
	@RequestMapping("empl_update.do")
	public ModelAndView empl_update(Employee employee, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        Employee e = (Employee)session.getAttribute("employee");
		
        e.setName(employee.getName());
        e.setPassword(employee.getPassword());
        employeeService.update(e);
        session.setAttribute("employee", e);
        
        mav.setViewName("jsp/employee/index");
        return mav;
	}
	
	@RequestMapping("empl_list.do")
	public ModelAndView empl_list(){
		ModelAndView mav=new ModelAndView();
		List<Employee> emp_list=employeeService.getAllEmployees();
		mav.addObject("empl_list",emp_list);
		mav.setViewName("jsp/manager/empl_list");
		return mav;
	}
	
	@RequestMapping("dep_empl_list.do")
	public ModelAndView empl_list(@RequestParam("dep_id")int dep_id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("empl_list",employeeService.getAllEmployeesByDep_id(dep_id));
		mav.addObject("dep_name",departmentService.getDepartmentById(dep_id).getName());
		mav.setViewName("jsp/manager/empl_list");
		return mav;
	}

	@RequestMapping("manager_empl_update_view.do")
	public ModelAndView manager_empl_update_view(@RequestParam("id")int id){
		ModelAndView mav=new ModelAndView();
		Employee e=employeeService.getEmployeeById(id);
		mav.addObject("old_empl",e);
		mav.setViewName("jsp/manager/empl_update");
		return mav;
	}
	
	@RequestMapping("manager_empl_update.do")
	public ModelAndView manager_empl_update(Employee e){
		ModelAndView mav = new ModelAndView();
        if(employeeService.update(e)==false){
        	mav.addObject("error", "部门编号"+e.getDep_id()+"不存在");
    		Employee old_e=employeeService.getEmployeeById(e.getId());
    		mav.addObject("old_empl",old_e);
            mav.setViewName("jsp/manager/empl_update");
    		return mav;
        }
        mav.setViewName("jsp/manager/index");
        return mav;
	}
	
	@RequestMapping("manager_empl_delete.do")
	public ModelAndView manager_empl_delete(@RequestParam("id") int id){
		ModelAndView mav = new ModelAndView();
        if(employeeService.delete(id)==false){
        	mav.addObject("error", "员工编号为"+id+"的是部门主管，请先修改相应部门");
    		mav.addObject("dep_list",departmentService.getAllDepartments());
    		mav.setViewName("jsp/manager/dep_list");
    		return mav;
        }
        mav.setViewName("jsp/manager/index");
        return mav;
	}
	
	@RequestMapping("empl_search_view.do")
	public ModelAndView empl_search_view(){
		ModelAndView mav = new ModelAndView();
    	mav.setViewName("jsp/manager/empl_search");
        return mav;
	}
	
	@RequestMapping("empl_search.do")
	public ModelAndView empl_search(@RequestParam("id") int id){
		ModelAndView mav = new ModelAndView();
		Employee e=employeeService.getEmployeeById(id);
        if(e==null){
        	mav.addObject("error", "员工编号为"+id+"不存在");
    		mav.setViewName("jsp/manager/empl_search");
    		return mav;
        }
        List<Employee> empl_list=new ArrayList<>();
        empl_list.add(employeeService.getEmployeeById(id));
        mav.addObject("empl_list",empl_list);
        mav.setViewName("jsp/manager/empl_list");
        return mav;
	}
	
	
}
