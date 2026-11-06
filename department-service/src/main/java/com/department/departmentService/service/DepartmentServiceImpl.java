package com.department.departmentService.service;

import com.department.departmentService.mapper.DepartmentMapper;
import com.department.departmentService.dto.DepartmentDto;
import com.department.departmentService.entity.Department;
import com.department.departmentService.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = departmentMapper.toDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto findDepartmentById(long id) {
        Department department = departmentRepository.findById(id);
        return departmentMapper.toDepartmentDto(department);
    }
}
