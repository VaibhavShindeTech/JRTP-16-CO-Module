package com.vaibhavshindetech.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhavshindetech.entities.CoTriggerEntity;

public interface CoTriggerRepository extends JpaRepository<CoTriggerEntity, Serializable>{
	public List<CoTriggerEntity> findByCoTriggerStatus(String status);
}
