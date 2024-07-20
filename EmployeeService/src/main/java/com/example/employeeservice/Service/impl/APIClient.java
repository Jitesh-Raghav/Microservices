package com.example.employeeservice.Service.impl;

import com.example.employeeservice.Dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url="http://localhost:8080" ,value="DEPARTMENT-SERVICE")
@FeignClient(name="DEPARTMENT-SERVICE")   //Load Balancing-running multiple instances of DepartmentService, and calling whatever service which is up using . SpringCloudStarter-Netflix Eureka client dependency internally is calling SpringCloudStarter-NetflixEurekaLoadBalancer to perform all this..
public interface APIClient {

    //get department REST API
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}


//LoadBalancing- we're running multiple instances of DepartmentService, and if one instance stops then also we get rest api response, that means both of the instances were balancing the load..