package com.department.departmentService.repository;

import com.department.departmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department save(Department department);

    public Department findById(long id);
}
