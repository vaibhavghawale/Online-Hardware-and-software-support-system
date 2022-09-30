package com.project.deo;

import java.util.List;

import com.project.bean.Engineer;
import com.project.bean.Problem;
import com.project.exceptions.EngineerException;
import com.project.exceptions.ProblemException;

public interface ProblemDao {

	public String CreateProblem(Problem problem);
	
	public List<Problem> getAllProblemList()throws ProblemException;
	
	public String updateStatus(String sts,int id) throws ProblemException;
	
//	public String getAssignProblemList(String pname)throws ProblemException;
	
//	public String changePassword(String username, String password, String newpassword) throws ProblemException;
}
