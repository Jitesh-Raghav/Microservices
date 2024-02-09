package com.example.departmentservice.Repository;

import com.example.departmentservice.Dto.DepartmentDto;
import com.example.departmentservice.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);
}
