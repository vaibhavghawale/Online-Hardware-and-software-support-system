package com.project.deo;
import com.project.bean.Engineer;
import com.project.exceptions.EngineerException;

public interface EngineerDao {

	public String registerEngineer(Engineer engineer);
	
	public Engineer loginEngineer(String EngUserName, String EngPassword)throws EngineerException;
	
}


//mysql> create table Engineer(
//	    -> EngId int primary key auto_increment,
//	    -> EngName varchar(15),
//	    -> EngUserName varchar(15),
//	    -> EngPassword varchar(15),
//	    -> EngCategory varchar(20)
//	    -> );
//	Query OK, 0 rows affected (0.05 sec)