package com.formation.wiki.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idStatus;
	private boolean published;
	private boolean waitingForValidaition;
	private boolean reportedAsAbsed;
	
	
	
	public boolean getPublished() {
		return published;
	}
	public void setPublished(Boolean published) {
		this.published = published;
	}
	public boolean getWaitingForValidaition() {
		return waitingForValidaition;
	}
	public void setWaitingForValidaition(Boolean waitingForValidaition) {
		this.waitingForValidaition = waitingForValidaition;
	}
	public boolean getReportedAsAbsed() {
		return reportedAsAbsed;
	}
	public void setReportedAsAbsed(Boolean reportedAsAbsed) {
		this.reportedAsAbsed = reportedAsAbsed;
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
