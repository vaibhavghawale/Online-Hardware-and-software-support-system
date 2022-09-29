package com.project.usecases;

import java.util.Scanner;
import com.project.bean.Engineer;
import com.project.deo.EngineerDao;
import com.project.deo.EngineerDaoImpl;
import com.project.exceptions.EngineerException;

public class EngineerLoginUseCase {

public static void main(String[] args) {
		
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String EngUserName = sc.next();
		
		System.out.println("Enter Password:");
		String EngPassword = sc.next();
		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			Engineer engineer= dao.loginEngineer(EngUserName, EngPassword);
		
	 		System.out.println("Welcome to Engineer page :"+engineer.getEngName());
	 	
	 	
		}catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
		
	sc.close();	
	}
	

}
