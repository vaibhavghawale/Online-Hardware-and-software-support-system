package com.project.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.bean.Employee;
import com.project.bean.Engineer;
import com.project.exceptions.EmployeeException;
import com.project.exceptions.EngineerException;
import com.project.utility.DButil;

public class EngineerDaoImpl implements EngineerDao {

	@Override
	public String registerEngineer(Engineer engineer) {
	
		String message="Not Inserted";
		
	
	
	try(Connection conn=DButil.provideConnection()) {
		
	PreparedStatement ps=conn.prepareStatement("insert into Engineer(EngName,EngUserName,EngPassword,EngCategory) values(?,?,?,?)");
	
	ps.setString(1, engineer.getEngName() );
	ps.setString(2, engineer.getEngUserName());
	ps.setString(3, engineer.getEngPassword());
	ps.setString(4, engineer.getEngCategory());
	
	int x= ps.executeUpdate();
	
	if(x>0) message="Engineer Registration succesfully";
	
	} catch (SQLException e) {
		// TODO: handle exception
		message=e.getMessage();
	}
		
		
		return message;
	}

	@Override
	public Engineer loginEngineer(String EngUserName, String EngPassword) throws EngineerException {
	
		
     Engineer engineer=null;
		
		
		try(Connection conn= DButil.provideConnection() ){
		
		PreparedStatement ps =conn.prepareStatement("select * from Engineer where engUserName=? AND engPassword=?");
		
		ps.setString(1, EngUserName);
		ps.setString(2, EngPassword);
		
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			
			int id= rs.getInt("EngId");
			String n= rs.getString("EngName");
			String e= rs.getString("EngUserName");
			String p= rs.getString("EngPassword");
			String c= rs.getString("EngCategory");
			
			
		engineer=new Engineer(id,n,e,p, c);	
			
			
		}else
			throw new EngineerException("Invalid Username or password.. ");
		
		
		
		
	} catch (SQLException e) {
		throw new EngineerException(e.getMessage());
	}


	return engineer;
		
		
	}

	
	
}
