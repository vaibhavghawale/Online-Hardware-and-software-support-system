package com.project.usecases;

import java.util.Scanner;

import com.project.deo.EngineerDao;
import com.project.deo.EngineerDaoImpl;
import com.project.deo.ProblemDao;
import com.project.deo.ProblemDaoImpl;
import com.project.exceptions.EngineerException;
import com.project.exceptions.ProblemException;

public class UpdatePasswordToEngineerUseCase {

	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a username");
		String username= sc.next();
		
		System.out.println("Enter a password");
		String password= sc.next();
		
		System.out.println("Enter a new username");
		String newpassword= sc.next();
		
		EngineerDao deo8 = new EngineerDaoImpl();
		
		try {
			String changepass = deo8.changePassword(username, password, newpassword);
			System.out.println(changepass);
			
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
