package com.jadecross.payroll.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String name;
	@NonNull
	private String role;
}