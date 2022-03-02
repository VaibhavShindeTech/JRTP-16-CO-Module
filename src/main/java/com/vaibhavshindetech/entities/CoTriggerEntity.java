package com.vaibhavshindetech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CO_TRIGGER")
public class CoTriggerEntity {
	@Id
	@Column(name = "CO_TRIGGER_ID")
	private Integer coTriggerId;
	@Column(name = "CASE_ID")
	private Integer caseId;
	@Column(name = "CO_TRIGGER_STATUS")
	private String coTriggerStatus;
}
