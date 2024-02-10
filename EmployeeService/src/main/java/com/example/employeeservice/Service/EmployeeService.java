package com.example.employeeservice.Service;

import com.example.employeeservice.Dto.APIResponseDto;
import com.example.employeeservice.Dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
