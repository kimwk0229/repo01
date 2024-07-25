package com.jadecross.payroll.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jadecross.payroll.domain.Employee;
import com.jadecross.payroll.exception.EmployeeNotFoundException;
import com.jadecross.payroll.repository.EmployeeRepository;

@RestController
class EmployeeController {

	private final EmployeeRepository repository;

	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/employees")  //사원 목록 조회..
	List<Employee> all() {
		return repository.findAll();
	}

	@PostMapping("/employees")  //사원 추가..
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}

	@GetMapping("/employees/{id}")  //사원 조회
	Employee one(@PathVariable("id") Long id) {

		return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@PutMapping("/employees/{id}")  //사원 수정
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable("id") Long id) {

		return repository.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return repository.save(employee);
		}).orElseGet(() -> {
			return repository.save(newEmployee);
		});
	}

	@DeleteMapping("/employees/{id}")  //사원 삭제 1122
	void deleteEmployee(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}
}