package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SelfAssessmentDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.CovidResultRepo;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CovidResultRepo covidResultRepo;
	
	@Override
	public Map<String, Object> registerUser(UserDto userDto) {
		
		UserEntity user = userRepo.save(extractUserEntity(userDto));
		
		Map<String, Object> userId = new HashMap<>();
		userId.put("userId", user.getUserId());
		return userId;
	}

	private UserEntity extractUserEntity(UserDto userDto) {
		
		UserEntity user = new UserEntity();
		user.setMobileNumber(userDto.getPhoneNumber());
		user.setPinCode(userDto.getPinCode());
		user.setName(userDto.getName());
		return user;
	}

	@Override
	public Map<String, Object> selfAssessment(SelfAssessmentDto selfAssessmentDto) {
		int riskPercent = this.getAssessmentResult(selfAssessmentDto);
		
		Map<String, Object> covidResults =new HashMap<>();
		covidResults.put("riskPercentage", riskPercent);
		return covidResults;
	}

	private Integer getAssessmentResult(SelfAssessmentDto selfAssessmentDto) {
		
		int symptoms= this.getSymptoms(selfAssessmentDto);
		Boolean hasTravelHistory = selfAssessmentDto.getTravelHistory();
		Boolean hasContactWithCovidPatient = selfAssessmentDto.getcontactWithCovidPatient();
		
		boolean hasCovidChances = hasTravelHistory || hasContactWithCovidPatient;
		
		if(symptoms==0 && !hasCovidChances) {
			return 5;
		}
		if(symptoms==1 && hasCovidChances) {
			return 50;
		}
		if(symptoms==2  && hasCovidChances ) {
			return 75;
		}
		if(symptoms>2 && hasCovidChances ) {
			return 95;
		}
		return 50;
	}

	private int getSymptoms(SelfAssessmentDto selfAssessmentDto) {
		
		if(selfAssessmentDto.getSymptoms()==null) {
			return 0;
		}
		return selfAssessmentDto.getSymptoms().length;
	}

	@Override
	public Map<String, Object> getZoneInfo(Map<String, Object> zoneDetails) {
		
		String pinCode = (String)zoneDetails.get("pinCode");
		List<Integer> users = userRepo.getDistictUsers(pinCode);
		
		Integer positiveCases = covidResultRepo.getCovidCases(users);
		String zoneType = getCovidZone(positiveCases);
		
		Map<String, Object> totalCases =new HashMap<>();
		totalCases.put("zoneType", zoneType);
		totalCases.put("numCases", positiveCases);
		
		return totalCases;
	}

	private String getCovidZone(Integer positiveCases) {
		
		if(positiveCases>5) {
			return "RED";
		}
		if(positiveCases>0) {
			return "ORANGE";
		}
		return "GREEN";
	}

}
