package com.employee.employeeService.controller;

import com.employee.employeeService.dto.EmployeeDeptResponseDto;
import com.employee.employeeService.dto.EmployeeDto;
import com.employee.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody  EmployeeDto employeeDto) {

        EmployeeDto empDto = employeeService.save(employeeDto);
        return ResponseEntity.ok().body(empDto);

    }

    @GetMapping("/{emp-id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("emp-id") Long id) {
        return ResponseEntity.ok().body(employeeService.getById(id));
    }

    @GetMapping("/empDept/{emp-id}")
    public ResponseEntity<EmployeeDeptResponseDto> getEmployeeDeptById(@PathVariable("emp-id") Long id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeDept(id));
    }

}
