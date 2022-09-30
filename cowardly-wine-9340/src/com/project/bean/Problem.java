package com.project.bean;

public class Problem {

	private int pid;
	private String pname;
	private String pcategory;
	
	public Problem() {
		// TODO Auto-generated constructor stub
	}
	
	public Problem(int pid, String pname, String pcategory) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcategory = pcategory;
	}
	public String getPcategory() {
		return pcategory;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}

	@Override
	public String toString() {
		return "Problem [pid=" + pid + ", pname=" + pname + ", pcategory=" + pcategory + "]";
	}
	
	
	
	
	
}
