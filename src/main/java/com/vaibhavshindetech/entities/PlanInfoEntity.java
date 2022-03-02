package com.vaibhavshindetech.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Entity
@Table(name = "Citizen_Plan_Info")
@Data
public class PlanInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Id")
	private Integer elibiligityID;
	@Column(name = "CASE_ID")
	private Integer caseId;
	@Column(name = "BENEFIT_AMT")
	private Integer benefitAmt;
	@Column(name = "DENIAL_REASON")
	private String denialReason;
	@Column(name = "END_DATE")
	private String endDate;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	@Column(name = "SSN")
	private String ssn;
	@Column(name = "START_DATE")
	private String startDate;
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
}
