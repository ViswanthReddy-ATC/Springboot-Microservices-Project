package com.department.departmentService.service;

import com.department.departmentService.dto.DepartmentDto;

public interface DepartmentService {

    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto findDepartmentById(long id);

}
