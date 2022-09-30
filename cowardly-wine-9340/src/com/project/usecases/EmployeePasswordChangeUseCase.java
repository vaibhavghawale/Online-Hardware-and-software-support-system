package com.project.usecases;

import java.util.Scanner;

import com.project.deo.EmployeeDao;
import com.project.deo.EmployeeDaoImlp;
import com.project.exceptions.EmployeeException;


public class EmployeePasswordChangeUseCase {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a username");
		String username= sc.next();
		
		System.out.println("Enter a password");
		String password= sc.next();
		
		System.out.println("Enter a new password");
		String newpassword= sc.next();
		
		EmployeeDao dao11=new EmployeeDaoImlp();
		
		try {
			String changepass = dao11.changePassword(username, password, newpassword);
			System.out.println(changepass);
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

}
