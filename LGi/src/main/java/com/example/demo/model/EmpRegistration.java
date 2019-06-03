package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class EmpRegistration {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String firstname;
private String mobilenumber;
private String officialemail;
private String refferedpersonname;
private String email;
private String phonenumber;

public EmpRegistration() {
	super();
}

public EmpRegistration( String firstname, String mobilenumber, String officialemail, String refferedpersonname,
		String email, String phonenumber) {
	super();
	this.firstname = firstname;
	this.mobilenumber = mobilenumber;
	this.officialemail = officialemail;
	this.refferedpersonname = refferedpersonname;
	this.email = email;
	this.phonenumber = phonenumber;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}
public String getOfficialemail() {
	return officialemail;
}
public void setOfficialemail(String officialemail) {
	this.officialemail = officialemail;
}
public String getRefferedpersonname() {
	return refferedpersonname;
}
public void setRefferedpersonname(String refferedpersonname) {
	this.refferedpersonname = refferedpersonname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}

}