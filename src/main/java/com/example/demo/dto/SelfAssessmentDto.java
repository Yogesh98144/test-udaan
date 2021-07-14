package com.example.demo.dto;

public class SelfAssessmentDto {

	private String userId;
	
	private String[] symptoms;
	
	private Boolean travelHistory;
	
	private Boolean contactWithCovidPatient;

	public String getUserId() {
		return userId;
	}

	public String[] getSymptoms() {
		return symptoms;
	}

	public Boolean getTravelHistory() {
		return travelHistory==null? false:travelHistory;
	}

	public Boolean getcontactWithCovidPatient() {
		return contactWithCovidPatient==null? false:contactWithCovidPatient;
	}
	
}
