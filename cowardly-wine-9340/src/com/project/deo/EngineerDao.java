package com.project.deo;

import com.project.bean.Engineer;

public interface EngineerDao {

	public String registerEngineer(Engineer engineer);
	
}


//mysql> create table Engineer(
//	    -> EngId int primary key auto_increment,
//	    -> EngName varchar(15),
//	    -> EngUserName varchar(15),
//	    -> EngPassword varchar(15),
//	    -> EngCategory varchar(20)
//	    -> );
//	Query OK, 0 rows affected (0.05 sec)