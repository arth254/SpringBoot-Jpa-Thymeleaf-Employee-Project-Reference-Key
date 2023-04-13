package com.aurosoft.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.employee.entity.Department;
import com.aurosoft.employee.entity.Employee;
import com.aurosoft.employee.service.DepartmentService;
import com.aurosoft.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
 private EmployeeService employeeService;
 
 private DepartmentService departmentService;
	
	public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
    super();
    this.employeeService = employeeService;
    this.departmentService = departmentService;
}
	@GetMapping("/list")
	public String listEmployee(Model m)
	{
  	List<Employee> list = employeeService.listAllEmployees();
  	m.addAttribute("list", list);
  	return "employee/list";
  	
	}
	@GetMapping("/new")
	public String showForm(Employee employee,Model m)
	{
	    List<Department> departments=departmentService.listAllDepartments();
	    m.addAttribute("list",departments);
		return "/employee/add";
	}
	
	@PostMapping("/insert")
	
		public String insert(@ModelAttribute("employee") Employee employee)
		{
			employeeService.insertEmployee(employee);
			return "redirect:/list";
		}
	
	@GetMapping(value="/edit/{id}")
	public String edit(@PathVariable int id, Model m)
	{
	    List<Department> departments=departmentService.listAllDepartments();
	    m.addAttribute("list",departments);
		Employee employee= employeeService.getEmployeeById(id);
		m.addAttribute("employee", employee);
		return "employee/edit";
		
	}
	
	@PostMapping(value = "/update")
	public String update(@ModelAttribute("employee") Employee employee)
	{
		employeeService.updateEmployee(employee);
		return "redirect:/employee/list";
		
	}
	
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable int id, Model m)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/employee/list";
		
	}
	
	
	
}
