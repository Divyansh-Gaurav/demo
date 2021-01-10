package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	@Query("select u from User u where u.id=:id")
	 User findByUserId(Long id);
	
	@Query(value="select u.* from users u",nativeQuery = true)
	List<User> findAll();
}
