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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="MEETINGS")
public class Meetings implements Serializable {

	private static final long serialVersionUID = 7973137071150732270L;

	@Id
	@Column(name="MEETING_ID")
	@SequenceGenerator(name="MEETING_SEQ", sequenceName="MEETING_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEETING_SEQ")
	private Integer meetingId;
	
	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="MEETING_DATE")
	private Date meetingDate;
	
	@Column(name="START_TIME")
	private String startTime;
	
	@Column(name="STOP_TIME")
	private String stopTime;
	
	@Column(name="LOCATION")
	private String location;
		
	public Meetings() {
		
	}		

	@Override
	public String toString() {
		return "Meetings [meetingId=" + meetingId + ", subject=" + subject + ", meetingDate=" + meetingDate
				+ ", startTime=" + startTime + ", stopTime=" + stopTime + ", location=" + location + ", status="
				//+ status 
				+ "]";
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
