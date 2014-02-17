package com.simpleblog.form;

//import com.simpleblog.annotation.FieldEquals;
//import com.simpleblog.dao.Factory;
import com.simpleblog.entity.Member;

/*
 * This annotation has been taken from 
 * http://www.seostella.com/ru/article/2012/06/21/annotaciya-dlya-proverki-ravenstva-dvuh-poley-formy-v-spring-mvc.html 
 */
//@FieldEquals(field="password", equalsTo="confirmPassword", message="Password and Confirm password is not match!")
public class RegistrationForm {

//	@NotNull(message="User name field cannot be empty")
//	@Size(min=4, max=20, message="User name can be more than 4 characters and less than 20 characters")
	
	//@NotEmpty(message="User name field cannot be empty")
	//@Size(min=4, max=20)
	private String userName;
	
//	@NotNull(message="Password field cannot be empty")
//	@Size(min=4, max=20, message="Password can be more than 4 characters and less than 20 characters")
	
	//@NotEmpty
	//@Size(min=4, max=20)
	private String password;
	
//	@NotNull(message="Password field cannot be empty")
	
	//@NotEmpty
	private String confirmPassword;
	
//	@NotNull(message="Email must not be empty")
/*	@Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
	      "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
	      "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
	      "+(?:[a-zA-Z]){2,}\\.?)$",
	      message = "This email is wrong") */
	
	//@NotEmpty
	//@Email
	private String email;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Member saveMember(){
		Member member = new Member();
		member.setName(userName);
		member.setEmail(email);
		member.setPassword(password);
		return member;
	}

}
