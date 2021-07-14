package com.example.demo.service;

import java.util.Map;

import com.example.demo.dto.CovidResult;
import com.example.demo.dto.HealthWorkerDto;

public interface HealthWorkerService {

	Map<String, Object> registerWorker(HealthWorkerDto workerDto);

	Map<String, Object> updateCovidResult(CovidResult result);

}
