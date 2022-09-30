package com.project.deo;

import com.project.bean.Hod;
import com.project.exceptions.HodException;

public interface HodDao {

	public String loginHod(String username, String password)throws HodException;

	
}
