package com.simpleblog.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="role_name")
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="member_relationship", 
			joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
			inverseJoinColumns = {@JoinColumn(name="member_id", referencedColumnName="id")}
	)
	private Set<Member> memberRoles;
	
	public int getId() {  
		return id;  
	}  
	  
	public void setId(int id) {  
		this.id = id;  
	}  
	  
	public String getRole() {  
		return role;  
	}  
	  
	public void setRole(String role) {  
		this.role = role;  
	}  
	  
	public Set<Member> getMemberRoles() {  
		return memberRoles;  
	}  
	  
	public void setUserRoles(Set<Member> memberRoles) {  
		this.memberRoles = memberRoles;  
	}  
	
}
