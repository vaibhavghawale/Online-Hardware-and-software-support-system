package com.project.deo;

import java.util.List;

import com.project.bean.Employee;
import com.project.exceptions.EmployeeException;
import com.project.exceptions.EngineerException;

public interface EmployeeDao {

	
	// register a employee:
	public String registerEmployee(Employee employee);
	
	
	// login a employee
	public Employee loginEmployee(String EmpUserName, String EmpPassword)throws EmployeeException;
	
	// list of employee;
	public List<Employee> getEmployeeDetails()throws EmployeeException;
	
}
