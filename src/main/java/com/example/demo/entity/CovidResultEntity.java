package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="covid_results")
public class CovidResultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="result_id")
	public Integer resultId;
	
	@Column(name="worker_id")
	private Integer workerId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="is_positive")
	private Boolean isPositive;

	public CovidResultEntity() {
		super();
	}

	public CovidResultEntity(Integer resultId, Integer workerId, Integer userId, Boolean isPositive) {
		super();
		this.resultId = resultId;
		this.workerId = workerId;
		this.userId = userId;
		this.isPositive = isPositive;
	}

	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(Boolean isPositive) {
		this.isPositive = isPositive;
	}
	
	
}
