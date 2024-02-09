package com.example.departmentservice.Service;

import com.example.departmentservice.Dto.DepartmentDto;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
