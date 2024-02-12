package com.example.employeeservice.Service.impl;

import com.example.employeeservice.Dto.APIResponseDto;
import com.example.employeeservice.Dto.DepartmentDto;
import com.example.employeeservice.Dto.EmployeeDto;
import com.example.employeeservice.Entity.Employee;
import com.example.employeeservice.Repository.EmployeeRepository;
import com.example.employeeservice.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;
    //private WebClient webClient;
    private APIClient apiClient;



    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        //dto to jpa entity
        Employee employee= new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode());
        Employee savedEmp= employeeRepository.save(employee);

        //jpa to dto
       EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmp.getId(),
               savedEmp.getFirstName(),
               savedEmp.getLastName(),
               savedEmp.getEmail(),
               savedEmp.getDepartmentCode());
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
       Employee employee= employeeRepository.findById(employeeId).get();

    //communicating with other microservice using restTemplate, which returns a ResponseEntity, so uske object mai we stored..

//     ResponseEntity<DepartmentDto> responseEntity=  restTemplate.getForEntity("http://localhost:8080/api/departments/"
//                     + employee.getDepartmentCode(),
//                        DepartmentDto.class);
//   DepartmentDto departmentDto = responseEntity.getBody();


 //        communicating with other microservice using WebClient
 //       DepartmentDto departmentDto= webClient.get().uri("http://localhost:8080/api/departments/"
//                     + employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();


       //COMMUNICATION BY OPEN FIEGIN CLIENT
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());



       //need to create another dto class to send both employee and department dto, or to return them...
       EmployeeDto employeeDto = new EmployeeDto(employee.getId(),
               employee.getFirstName(),
               employee.getLastName(),
               employee.getEmail(),
               employee.getDepartmentCode());


       //return employeeDto;

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
