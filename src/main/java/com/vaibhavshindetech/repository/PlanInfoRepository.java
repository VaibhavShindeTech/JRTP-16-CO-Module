package com.vaibhavshindetech.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vaibhavshindetech.entities.PlanInfoEntity;

public interface PlanInfoRepository extends JpaRepository<PlanInfoEntity, Serializable>{
	@Query("from PlanInfoEntity where caseId=:caseId")
	public PlanInfoEntity findAllByCaseId(Integer caseId);
	
	public PlanInfoEntity findByCaseId(Integer caseId);

}
