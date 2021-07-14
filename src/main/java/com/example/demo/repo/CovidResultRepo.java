package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CovidResultEntity;

@Repository
public interface CovidResultRepo extends CrudRepository<CovidResultEntity, Integer>{

	@Query(nativeQuery=true, value="select count(distinct(user_id)) from covid_results where is_positive =true AND user_id IN (:users)")
	Integer getCovidCases(List<Integer> users);

}
