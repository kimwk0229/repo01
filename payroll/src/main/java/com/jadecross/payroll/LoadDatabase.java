package com.jadecross.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jadecross.payroll.domain.Employee;
import com.jadecross.payroll.repository.EmployeeRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {

		return args -> {
//			log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
//			log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
//			log.info("Preloading " + repository.save(new Employee("홍길동", "기술")));
//			log.info("Preloading " + repository.save(new Employee("강호동", "영업")));
		};
	}
}