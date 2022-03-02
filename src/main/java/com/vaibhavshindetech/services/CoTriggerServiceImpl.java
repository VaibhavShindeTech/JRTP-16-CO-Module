package com.vaibhavshindetech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhavshindetech.entities.CoTriggerEntity;
import com.vaibhavshindetech.repository.CoTriggerRepository;

@Service
public class CoTriggerServiceImpl implements CoTriggerService{
	@Autowired
	private CoTriggerRepository coTriggerRepository; 
	@Override
	public List<CoTriggerEntity> getAllPendingRecords() {
		List<CoTriggerEntity> pendingRecord = coTriggerRepository.findByCoTriggerStatus("PENDING");
		return pendingRecord;
	}
	@Override
	public void updateCoTriggerStatus(CoTriggerEntity coTriggerEntity) {
		coTriggerRepository.save(coTriggerEntity);
	}
}
