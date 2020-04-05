package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.domain.Employee;
import spring.repository.EmployeeRepository;

@RestController
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee/{id}")
    public Employee showEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id).get();
    }
}