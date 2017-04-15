package com.dhub.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_STATS")
public class UserStats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4063697320870776478L;

	@Id
	@Column(name="USER_STATS_ID")
	@SequenceGenerator(name="STATS_SEQ", sequenceName="STATS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATS_SEQ")
	private Integer userStatId;
	
	@Column(name="USER_ID")
	private Integer userId;	
	
	@Column(name="TIME_SPENT")
	private Integer timeSpent;
	
	@Column(name="MINOR")
	private Integer minor;
	
	@Column(name="MAJOR")
	private Integer major;
	
	@Column(name="CRITICAL")
	private Integer critical;
	
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Projects projects;

	@ManyToOne
	private Users user;	
	
	public UserStats() {

	}	

	@Override
	public String toString() {
		return "UserStats [userStatId=" + userStatId + ", userId=" + userId + ", timeSpent=" + timeSpent + ", minor="
				+ minor + ", major=" + major + ", critical=" + critical + ", projects=" + projects + "]";
	}

	public Integer getUserStatId() {
		return userStatId;
	}

	public void setUserStatId(Integer userStatId) {
		this.userStatId = userStatId;
	}	

	public Integer getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(Integer timeSpent) {
		this.timeSpent = timeSpent;
	}

	public Integer getMinor() {
		return minor;
	}

	public void setMinor(Integer minor) {
		this.minor = minor;
	}

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	public Integer getCritical() {
		return critical;
	}

	public void setCritical(Integer critical) {
		this.critical = critical;
	}	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
