package com.example.departmentservice.Service.impl;

import com.example.departmentservice.Dto.DepartmentDto;
import com.example.departmentservice.Entity.Department;
import com.example.departmentservice.Repository.DepartmentRepository;
import com.example.departmentservice.Service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert dto to jpa entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        Department savedDepartment= departmentRepository.save(department);

        //convert jpa entity to dto
        DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode());

         return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
       Department departmentByCode = departmentRepository.findByDepartmentCode(departmentCode);

       DepartmentDto departmentDto = new DepartmentDto(departmentByCode.getId(),
               departmentByCode.getDepartmentName(),
               departmentByCode.getDepartmentDescription(),
               departmentByCode.getDepartmentCode());

       return departmentDto;
    }
}
