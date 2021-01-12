package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Documents;

@Repository
public interface DocRepository extends JpaRepository<Documents, Long>{

}
