package com.project.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.project.bean.Employee;
import com.project.bean.Problem;
import com.project.exceptions.EmployeeException;
import com.project.exceptions.EngineerException;
import com.project.utility.DButil;

public class EmployeeDaoImlp implements EmployeeDao {
	
	@Override
	public String registerEmployee(Employee employee) {
	
		String message="Not Inserted";
		
	
	
	try(Connection conn=DButil.provideConnection()) {
		
	PreparedStatement ps=conn.prepareStatement("insert into Employee(empName,empUserName,empPassword) values(?,?,?)");
	
	ps.setString(1, employee.getEmpName() );
	ps.setString(2, employee.getEmpUserName());
	ps.setString(3, employee.getEmpPassword());
	
	int x= ps.executeUpdate();
	
	if(x>0) message="Employee Registration succesfully";
	
	} catch (SQLException e) {
		// TODO: handle exception
		message=e.getMessage();
	}
		
		
		return message;
	}

	@Override
	public Employee loginEmployee(String EmpUserName, String EmpPassword) throws EmployeeException {
		
		Employee employee=null;
		
		
		try(Connection conn= DButil.provideConnection() ){
		
		PreparedStatement ps =conn.prepareStatement("select * from Employee where empUserName=? AND empPassword=?");
		
		ps.setString(1, EmpUserName);
		ps.setString(2, EmpPassword);
		
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			
			int id= rs.getInt("empID");
			String n= rs.getString("empName");
			String e= rs.getString("empUserName");
			String p= rs.getString("empPassword");
			
			
		employee=new Employee(id,n,e,p);	
			
			
		}else
			throw new EmployeeException("Invalid Username or password.. ");
		
		
		
		
	} catch (SQLException e) {
		throw new EmployeeException(e.getMessage());
	}


	return employee;
	
	}

	@Override
	public List<Employee> getEmployeeDetails() throws EmployeeException {
	
		
		List<Employee> employees= new ArrayList<>();
		
		try(Connection conn=DButil.provideConnection()) {
			
		PreparedStatement ps=	conn.prepareStatement("select * from employee");
			
		 ResultSet	rs =ps.executeQuery();
		
		while(rs.next()) {
			
			int id= rs.getInt("empID");
			String n= rs.getString("empName");
			String e= rs.getString("empUserName");
			String p= rs.getString("empPassword");
			
			
		   Employee employee=new Employee(id,n,e,p);	
		   employees.add(employee);
		}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			throw new EmployeeException(e.getMessage());
			
		}
		
		if(employees.size()==0) {
			throw new EmployeeException("No Employee Found");
		}
		
		return employees;
		
	}

	@Override
	public String changePassword(String username, String password, String newpassword) throws EmployeeException {

		String message = "Password Not Updated";
		
        try(Connection conn = DButil.provideConnection()) {
		
		
		PreparedStatement ps= conn.prepareStatement("update employee set emppassword= ? where empUserName= ? AND empPassword= ? ");			
		
		ps.setString(1, newpassword);
		ps.setString(2, username);
		ps.setString(3, password);
		
		int x = ps.executeUpdate();
		
		if(x>0) {
			
			message = "Your password change successfully !";
		}
		else {
			
			throw new EmployeeException("Invalid Username or password.. ");
			
		}
		
    } catch (SQLException e) {
		throw new  EmployeeException(e.getMessage());
	}
	
	
	
	return message;
	}

//	@Override
//	public List<Problem> getAssignProblemList(String pname) throws EmployeeException {
//		
//		List<Problem> problems= new ArrayList<>();
//		
//		try(Connection conn=DButil.provideConnection()) {
//			
//		PreparedStatement ps=	conn.prepareStatement("select e.engid, e.engname,e.engcategory,p.pname,p.status from engineer e INNER JOIN problems p INNER JOIN employee_engineer ee ON e.engid=ee.reid AND p.pid=ee.rpid AND p.pname =?;");
//			
//		ResultSet	rs =ps.executeQuery();
//		
//		while(rs.next()) {
//			
//			if(rs.next()) {
//				
//				int id= rs.getInt("pid");
//				String n= rs.getString("pname");
//				String c= rs.getString("pcategory");
//				String s=rs.getString("status");
//				
//		   Problem	problem=new Problem(id,n,c, s);		
//		   problems.add(problem);
//		}
//			
//			
//		} }catch (SQLException e) {
//			// TODO: handle exception
//			
//			throw new EmployeeException(e.getMessage());
//			
//		}
//		
//		if(problems.size()==0) {
//			throw new EmployeeException("No Problem Found");
//		}
//		
//		return problems;
//	}
	
}	
