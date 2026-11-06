package com.employee.employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDeptResponseDto {

    private EmployeeDto employeeDto;

    private DepartmentDto departmentDto;

}
