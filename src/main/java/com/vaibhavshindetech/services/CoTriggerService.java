package com.vaibhavshindetech.services;

import java.util.List;

import com.vaibhavshindetech.entities.CoTriggerEntity;

public interface CoTriggerService {
	public List<CoTriggerEntity> getAllPendingRecords();

	public void updateCoTriggerStatus(CoTriggerEntity coTriggerEntity);
}
