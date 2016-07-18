package com.summer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.summer.model.Department;
import com.summer.service.DepartmentService;
import com.summer.service.EmployeeService;

@Controller
public class DepController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("dep_list.do")
	public ModelAndView dep_list(){
		ModelAndView mav=new ModelAndView();
		mav.addObject("dep_list",departmentService.getAllDepartments());
		mav.setViewName("jsp/manager/dep_list");
		return mav;
	}
	
	@RequestMapping("dep_add_view.do")
	public ModelAndView dep_add_view(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("jsp/manager/dep_add");
		return mav;
	}

	@RequestMapping("dep_add.do")
	public ModelAndView dep_add(Department department){
		ModelAndView mav=new ModelAndView();
		if(departmentService.add(department)==false){
			mav.addObject("error", "主管ID"+department.getLeader_id()+"不存在");
			mav.setViewName("jsp/manager/dep_add");
			return mav;
		}
		mav.setViewName("jsp/manager/index");
		return mav;
	}

	@RequestMapping("dep_update_view.do")
	public ModelAndView dep_update_view(@RequestParam("dep_id")int dep_id, HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		Department department=departmentService.getDepartmentById(dep_id);
		mav.addObject("old_dep",department);
		mav.setViewName("jsp/manager/dep_update");
		return mav;
	}
	
	@RequestMapping("dep_update.do")
	public ModelAndView dep_update(Department department,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		if(departmentService.update(department)==false){
			mav.addObject("error","主管ID"+department.getLeader_id()+"不存在");
			Department old_dep=departmentService.getDepartmentById(department.getId());
			mav.addObject("old_dep",old_dep);
			mav.setViewName("jsp/manager/dep_update");
			return mav;
		}

		mav.setViewName("jsp/manager/index");
		return mav;
	}
}
