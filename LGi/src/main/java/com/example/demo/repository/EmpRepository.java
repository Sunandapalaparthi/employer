package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmpRegistration;
@Repository
public interface EmpRepository  extends JpaRepository<EmpRegistration, Long>{

	boolean existsByEmail(String email);

}
