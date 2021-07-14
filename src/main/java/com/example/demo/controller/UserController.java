package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SelfAssessmentDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("user/register")
	public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserDto userDto){
		
		return new ResponseEntity<Map<String, Object>>(userService.registerUser(userDto),HttpStatus.OK);
		
	}
	
	@PostMapping("user/assessment")
	public ResponseEntity<Map<String, Object>> selfAssessment(@RequestBody SelfAssessmentDto selfAssessmentDto){
		
		return new ResponseEntity<Map<String, Object>>(userService.selfAssessment(selfAssessmentDto),HttpStatus.OK);
		
	}
	
	@GetMapping("zone/info")
	public ResponseEntity<Map<String, Object>> getZoneInfo(@RequestBody Map<String, Object> zoneDetails){
			
		return new ResponseEntity<Map<String, Object>>(userService.getZoneInfo(zoneDetails),HttpStatus.OK);
		
	}
}
