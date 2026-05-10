package com.deepak.binding;

import java.util.Arrays;


// FORM DATA BINDING HERE.....

public class Student {

	
	private Integer sid;
	private String name;
	private String email;
	private String course;

public Student(){
	System.out.println("Student defualt constructor...");

	System.out.println("####################");
}


	private String[] timings;
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String[] getTimings() {
		return timings;
	}
	public void setTimings(String[] timings) {
		this.timings = timings;
	}
	
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", email=" + email + ", course=" + course + ", timings="
				+ Arrays.toString(timings) + "]";
	}
	
	
}
