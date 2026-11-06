package com.department.departmentService.controller;

import com.department.departmentService.dto.DepartmentDto;
import com.department.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto SavedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return ResponseEntity.ok().body(SavedDepartmentDto);

    }

    @GetMapping("/{department-id}")
    public ResponseEntity<DepartmentDto> findDepartmentById( @PathVariable("department-id") Long id){
        DepartmentDto departmentDto = departmentService.findDepartmentById(id);
        return ResponseEntity.ok().body(departmentDto);

    }
}
