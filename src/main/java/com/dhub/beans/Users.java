package com.dhub.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="prototype")
@Entity
@Table(name="USERS")
public class Users implements Serializable {

	private static final long serialVersionUID = 7107120671996060276L;
	
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name="USER_SEQ", sequenceName="USER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ")
	private Integer userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;	

	@OneToOne
	@JoinColumn(name="ROLE_ID")
	 private Roles roles;
	
	@OneToMany
	@JoinTable(name="USER_MEETING",
		joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "MEETING_ID"))
	private List<Meetings> meetings;
	
	@OneToMany
	@JoinTable(name="USER_MEETING",
	joinColumns = @JoinColumn(name = "USER_ID"),
		inverseJoinColumns = @JoinColumn(name = "STATUS_ID"))
	private List<Status> status;
	
	@OneToMany
	@JoinTable(name="USER_STATS",
		joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
	private List<UserStats> userStats;
	
	@OneToMany
	@JoinTable(name="USER_FILTERS",
		joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "FILTER_SUBTYPE_ID"))
	private List<FilterSubtypes> filterSubtype;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}	

	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", email=" + email + ", phone=" + phone + ", roles=" + roles
				+ ", meetings=" + meetings + ", status=" + status + ", userStats=" + userStats + ", filterSubtype="
				+ filterSubtype + "]";
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<FilterSubtypes> getFilterSubtype() {
		return filterSubtype;
	}

	public void setFilterSubtype(List<FilterSubtypes> filterSubtype) {
		this.filterSubtype = filterSubtype;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	


	public List<UserStats> getUserStats() {
		return userStats;
	}

	public void setUserStats(List<UserStats> userStats) {
		this.userStats = userStats;
	}

	public List<FilterSubtypes> getSubtype() {
		return filterSubtype;
	}

	public void setSubtype(List<FilterSubtypes> filterSubtype) {
		this.filterSubtype = filterSubtype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
