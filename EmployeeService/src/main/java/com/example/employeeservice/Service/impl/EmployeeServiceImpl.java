package com.example.employeeservice.Service.impl;

import com.example.employeeservice.Dto.EmployeeDto;
import com.example.employeeservice.Entity.Employee;
import com.example.employeeservice.Repository.EmployeeRepository;
import com.example.employeeservice.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        //dto to jpa entity
        Employee employee= new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail());
        Employee savedEmp= employeeRepository.save(employee);

        //jpa to dto
       EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmp.getId(),
               savedEmp.getFirstName(),
               savedEmp.getLastName(),
               savedEmp.getEmail());
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee= employeeRepository.findById(employeeId).get();

       EmployeeDto employeeDto = new EmployeeDto(employee.getId(),
               employee.getFirstName(),
               employee.getLastName(),
               employee.getEmail());

       return employeeDto;
    }
}
