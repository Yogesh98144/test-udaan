package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CovidResult;
import com.example.demo.dto.HealthWorkerDto;
import com.example.demo.entity.CovidResultEntity;
import com.example.demo.entity.HealthWorkerEntity;
import com.example.demo.repo.CovidResultRepo;
import com.example.demo.repo.HealthWorkerRepository;

@Service
public class HealthWorkerServiceImpl implements HealthWorkerService{

	@Autowired
	HealthWorkerRepository healthWorkerRepo;

	@Autowired
	CovidResultRepo covidResultRepo;
	
	@Override
	public Map<String, Object> registerWorker(HealthWorkerDto workerDto) {

		HealthWorkerEntity workerhealth = healthWorkerRepo.save(extractWorkerEntity(workerDto));
		
		Map<String, Object> adminId=new HashMap<>();
		adminId.put("adminId", workerhealth.getUserId());
		return adminId;
	}

	private HealthWorkerEntity extractWorkerEntity(HealthWorkerDto workerDto) {
			
		HealthWorkerEntity worker = new HealthWorkerEntity();
		worker.setMobileNumber(workerDto.getPhoneNumber());
		worker.setPinCode(workerDto.getPinCode());
		worker.setName(workerDto.getName());
		return worker;
	}

	@Override
	public Map<String, Object> updateCovidResult(CovidResult result) {
		
		covidResultRepo.save(extractResultEntity(result));
		Map<String, Object> results=new HashMap<>();
		results.put("updated", true);
		return results;
	}

	private CovidResultEntity extractResultEntity(CovidResult result) {

		CovidResultEntity entity = new CovidResultEntity();
		entity.setWorkerId(result.getAdminId());
		boolean positive=result.getResult().equals("positive");
		entity.setIsPositive(positive);
		entity.setUserId(result.getUserId());
		
		return entity;
	}
}
