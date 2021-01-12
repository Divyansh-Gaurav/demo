package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="mail")
	private String mail;
	@Column(name="city")
	private String city;
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "user_id")
	private Set<File> files;
	
	public User() {
		super();
	}
	
	public User(Long userId, String firstName, String lastName, String mail, String city) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.city = city;
	}

	
	public User(Long userId, String firstName, String lastName, String mail, String city, Set<File> files) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.city = city;
		this.files = files;
	}

	public User(String firstName, String lastName, String mail, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.city = city;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail
				+ ", city=" + city + "]";
	}

	
}
