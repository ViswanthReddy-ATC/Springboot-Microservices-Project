package com.employee.employeeService.repository;

import com.employee.employeeService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public Employee save(Employee employee);

    public Employee findById(long id);
}
