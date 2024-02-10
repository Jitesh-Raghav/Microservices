package com.example.employeeservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {

    private EmployeeDto employee;
    private DepartmentDto department;
}
