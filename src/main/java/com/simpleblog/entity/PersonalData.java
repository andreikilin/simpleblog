package com.simpleblog.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="personal_data")
public class PersonalData {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String city;
	
	private Date bithDay;
}
