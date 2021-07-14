package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

@Repository
public interface UserRepository  extends CrudRepository<UserEntity, Integer>{

	@Query(nativeQuery=true, value="select user_id from pid where pin_code=:pinCode")
	List<Integer> getDistictUsers(String pinCode);

}
