package com.chainsys.application.controller;


import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.application.model.Employee;
import com.chainsys.application.model.EmployeeDao;

@RestController
public class Services {


	@RequestMapping("/getEmployee")
	public  String  getData(@RequestParam(name = "id") String id) {
	    int emp_id = Integer.parseInt(id);
	    Employee emp = EmployeeDao.getEmployeeById(emp_id);
	        return   emp.getFirst_name()+", " + emp.getLast_name()+", " + emp.getJob_id()+", " + emp.getSalary()+", "
	                + emp.getHire_date()+", " + emp.getEmail() ;
	    }
	@RequestMapping("/getAll")
	public String getAll()
	{
	    List<Employee> allEmployee=EmployeeDao.getAllEmployee();
	    Iterator<Employee> empIterator=allEmployee.iterator();
	    String result="";
	    while(empIterator.hasNext())
	    {
	        Employee emp = empIterator.next();
	        result +="<div>" + emp.getFirst_name()+", " + emp.getLast_name()+", " + emp.getJob_id()+", " + emp.getSalary()+", "
	        + emp.getHire_date()+", " + emp.getEmail() + "</div>" ;
	    }
	    return result;
	    
	}
	@RequestMapping(value="/newemployee",method=RequestMethod.POST)
	public int addNewEmployee() {
	    return 0;
	    
	}
	@RequestMapping(value="/newemployee",method=RequestMethod.PUT)
	public int modifyEmployee() {
	    return 0;
	    
	}
	@RequestMapping(value="/newemployee",method=RequestMethod.DELETE)
	public int Delete() {
	    return 0;
	    
	}
}
