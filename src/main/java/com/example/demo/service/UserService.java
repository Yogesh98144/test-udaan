package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.SelfAssessmentDto;
import com.example.demo.dto.UserDto;

public interface UserService {

	Map<String, Object> registerUser(UserDto userDto);

	Map<String, Object> selfAssessment(SelfAssessmentDto selfAssessmentDto);

	Map<String, Object> getZoneInfo(Map<String, Object> zoneDetails);

}
