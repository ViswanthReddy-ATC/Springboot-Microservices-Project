package com.employee.employeeService.service;

import com.employee.employeeService.dto.EmployeeDeptResponseDto;
import com.employee.employeeService.dto.EmployeeDto;

public interface EmployeeService {

    public EmployeeDto save(EmployeeDto employee);

    public EmployeeDto getById(long id);

    public EmployeeDeptResponseDto getEmployeeDept(long id);
}
