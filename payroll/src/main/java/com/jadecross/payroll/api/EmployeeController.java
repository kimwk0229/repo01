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

	@GetMapping("/employees")  //사원 목록
	List<Employee> all() {
		var emps = repository.findAll();

		return emps;
	}

	@PostMapping("/employees") //사원 등록
	Employee newEmployee(@RequestBody Employee newEmployee) {
		var newEmp = repository.save(newEmployee);

		return newEmp;
	}

	@GetMapping("/employees/{id}") //사원 상세 조회 
	Employee one(@PathVariable("id") Long id) {
		var emp = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		
		return emp;
	}

	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmp, @PathVariable("id") Long id) {
		return repository.findById(id).map(emp -> {
			emp.setName(newEmp.getName());
			emp.setRole(newEmp.getRole());

			return repository.save(emp);
		}).orElseGet(() -> {
			return repository.save(newEmp);
		});
	}

	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}
}