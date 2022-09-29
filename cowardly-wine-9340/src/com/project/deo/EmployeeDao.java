package com.project.deo;

import com.project.bean.Employee;
import com.project.exceptions.EmployeeException;

public interface EmployeeDao {

	public String registerEmployee(Employee employee);
	
	public Employee loginEmployee(String EmpUserName, String EmpPassword)throws EmployeeException;
}
