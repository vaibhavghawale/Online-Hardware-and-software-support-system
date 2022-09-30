package com.project.usecases;

import java.util.List;

import com.project.bean.Engineer;
import com.project.deo.EngineerDao;
import com.project.deo.EngineerDaoImpl;
import com.project.exceptions.EngineerException;

public class AllEngineeerDetails {

		public static void main(String[] args) {
			
			
			EngineerDao dao=new EngineerDaoImpl();
			try {
				
				List<Engineer> engineer = dao.getEngineersDetail();
				
				engineer.forEach(s -> System.out.println(s));
				
			} catch (EngineerException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
		
	}
		}
}
