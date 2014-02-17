package com.simpleblog.form;

import java.util.Date;

public class ProfileForm {

	private String firstName;
	private String lastName;
	private String city;
	Date birthDay;
	private String day;
	private String month;
	private String year;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public Date getBirthDay() {
		return this.birthDay;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public String getDay() {
		return this.day;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getMonth() {
		return this.month;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getYear() {
		return this.year;
	}
	
}
