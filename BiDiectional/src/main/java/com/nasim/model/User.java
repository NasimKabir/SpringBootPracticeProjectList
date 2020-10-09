package com.nasim.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 4, message = "Username atleast 4 charecter")
	private String username;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();

	 //@JsonIgnore
	@Size(min = 4, message = "password atleast 4 charecter")
	private String password;
	
	@Email
	@Size(min = 4, message = "Give valid email")
	private String email;

	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles;

	public User(@Size(min = 4, message = "Username atleast 4 charecter") String username,
			@Size(min = 4, message = "password atleast 4 charecter") String password,
			@Email @Size(min = 4, message = "Give valid email") String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
public User() {
}
}
