package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.HealthWorkerEntity;

@Repository
public interface HealthWorkerRepository  extends CrudRepository<HealthWorkerEntity, Integer>{

}
