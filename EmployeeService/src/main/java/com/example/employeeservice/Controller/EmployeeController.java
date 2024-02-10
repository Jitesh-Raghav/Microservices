package com.example.employeeservice.Controller;

import com.example.employeeservice.Dto.APIResponseDto;
import com.example.employeeservice.Dto.EmployeeDto;
import com.example.employeeservice.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //save employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmp=employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    //get employeeById REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto =employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
