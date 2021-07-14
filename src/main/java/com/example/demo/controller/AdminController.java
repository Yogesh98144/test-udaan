package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CovidResult;
import com.example.demo.dto.HealthWorkerDto;
import com.example.demo.service.HealthWorkerService;

@RestController
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	HealthWorkerService healthWorkerService;
	
	@PostMapping("worker/register")
	public ResponseEntity<Map<String, Object>> registerWorker(@RequestBody HealthWorkerDto workerDto){
		
		return new ResponseEntity<Map<String, Object>>(healthWorkerService.registerWorker(workerDto),HttpStatus.OK);
	}
	
	@PatchMapping("results/update")
	public ResponseEntity<Map<String, Object>> updateCovidResult(@RequestBody CovidResult result){
			
		return new ResponseEntity<Map<String, Object>>(healthWorkerService.updateCovidResult(result),HttpStatus.OK);
	}
		
}
