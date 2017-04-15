package com.dhub.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PROJECTS")
public class Projects implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7015757679783406272L;

	@Id
	@Column(name = "PROJECT_ID")
	@SequenceGenerator(name="PROJECT_SEQ", sequenceName="PROJECT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_SEQ")
	private Integer projectId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "STOP_DATE")
	private Date stopDate;

	@Column(name = "ISSUES")
	private Integer issues;
	
	@OneToMany
	@JoinTable(name="PROJECTS_PRODUCTS",
		joinColumns = @JoinColumn(name = "PROJECT_ID"),
			inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private List<Products> products;
	
	@OneToMany
	@JoinTable(name="USER_STATS",
		joinColumns = @JoinColumn(name = "PROJECT_ID"),
			inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	private List<UserStats> userStats;

	public Projects() {

	}	
	
	@Override
	public String toString() {
		return "Projects [projectId=" + projectId + ", name=" + name + ", startDate="
				+ startDate + ", stopDate=" + stopDate + ", issues=" + issues + 
				", products=" + products + "]";
	}


	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public Integer getIssues() {
		return issues;
	}

	public void setIssues(Integer issues) {
		this.issues = issues;
	}
}
