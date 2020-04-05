package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.domain.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}