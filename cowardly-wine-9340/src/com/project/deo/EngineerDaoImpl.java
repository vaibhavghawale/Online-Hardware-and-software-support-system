package com.project.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.bean.Engineer;
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

	
	
}
