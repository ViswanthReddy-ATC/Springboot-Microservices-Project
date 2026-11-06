package com.employee.employeeService.service;

import com.employee.employeeService.client.DepartmentClient;
import com.employee.employeeService.dto.DepartmentDto;
import com.employee.employeeService.dto.EmployeeDeptResponseDto;
import com.employee.employeeService.dto.EmployeeDto;
import com.employee.employeeService.entity.Employee;
import com.employee.employeeService.mapper.EmployeeMapper;
import com.employee.employeeService.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;
    private RestTemplate restTemplate;
    private WebClient webClient;
    private DepartmentClient departmentClient;

    @Override
    public EmployeeDto save(EmployeeDto employee) {
        Employee emp = employeeMapper.employeeDtoToEmployee(employee);
        Employee savedEmp =  employeeRepository.save(emp);
        return employeeMapper.employeeToEmployeeDto(savedEmp);
    }

    @Override
    public EmployeeDto getById(long id) {
        Employee emp = employeeRepository.getById(id);
        return employeeMapper.employeeToEmployeeDto(emp);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDeptResponseDto getEmployeeDept(long id) {

        EmployeeDto emp = getById(id);

        String url = "http://localhost:8080/api/departments/" + emp.getDeptId();

        //Calling Department service using Rest Template
       /* ResponseEntity<DepartmentDto> response =
                restTemplate.getForEntity(url, DepartmentDto.class);*/

        //Calling Department service using Webclient
       /* DepartmentDto departmentDto = webClient.get().uri(url).retrieve()
                .bodyToMono(DepartmentDto.class).block();*/

        //log.info("getEmployeeDept:{}",response.getBody());

        //DepartmentDto departmentDto = response.getBody();

        DepartmentDto departmentDto = departmentClient.getDepartmentById(emp.getDeptId());

        EmployeeDeptResponseDto responseDto =
                new EmployeeDeptResponseDto();

        responseDto.setDepartmentDto(departmentDto);
        responseDto.setEmployeeDto(emp);

        return responseDto;
    }
}
