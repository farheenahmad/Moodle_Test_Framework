package com.netsuite.tlh.testdata;

import com.framework.dataprovider.ITestData;

public class CreateBackupData implements ITestData {

	private String courseName;
	private String CourseShortName;
	private String userName1;
	private String userName2;
	private String userName3;
	private String role1;
	private String role2;
	private String role3;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserName1() {
		return userName1;
	}
	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}
	public String getUserName2() {
		return userName2;
	}
	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}
	public String getUserName3() {
		return userName3;
	}
	public void setUserName3(String userName3) {
		this.userName3 = userName3;
	}
	public String getRole1() {
		return role1;
	}
	public void setRole1(String role1) {
		this.role1 = role1;
	}
	public String getRole2() {
		return role2;
	}
	public void setRole2(String role2) {
		this.role2 = role2;
	}
	public String getRole3() {
		return role3;
	}
	public void setRole3(String role3) {
		this.role3 = role3;
	}
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseShortName() {
		return CourseShortName;
	}
	public void setCourseShortName(String courseShortName) {
		CourseShortName = courseShortName;
	}
	

	
}
