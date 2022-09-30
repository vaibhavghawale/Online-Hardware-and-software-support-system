package com.project.usecases;

import java.util.List;

import com.project.bean.Employee;
import com.project.deo.EmployeeDao;
import com.project.deo.EmployeeDaoImlp;
import com.project.exceptions.EmployeeException;

public class AllEmployeeDetails {

	public static void main(String[] args) {
		
		
		EmployeeDao dao=new EmployeeDaoImlp();
		
		
		try {
			
			List<Employee> employees=dao.getEmployeeDetails();
			employees.forEach(s -> System.out.println(s));
			
		} catch (EmployeeException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
}
