package com.dhub.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STATUS")
public class Status implements Serializable {
	
	private static final long serialVersionUID = 378390918046810275L;

	@Id
	@Column(name="STATUS_ID")
	@SequenceGenerator(name="STATUS_SEQ", sequenceName="STATUS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATUS_SEQ")
	private Integer statusId;
	
	@Column(name="STATUS")
	private String status;
	
	public Status() {
		
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", status=" + status + "]";
	}	
	
	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}
