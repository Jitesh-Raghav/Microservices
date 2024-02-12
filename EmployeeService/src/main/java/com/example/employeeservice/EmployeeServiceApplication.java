package com.example.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

//    @Bean
//    public RestTemplate restTemplate(){       //didn't added a dependency for it...
//        return new RestTemplate();
//    }

//    @Bean
//    public WebClient webClient(){               //added webflux dependency for it...
//        return WebClient.builder().build();
//    }


    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}


//USE THIS COMMONAD TO RUN DIFFERENT INSTANCES OF A MICCOSERVICE ON DIFFERENT PORTS,
//java -jar target/DepartmentService-0.0.1-SNAPSHOT.jar --server.port=8082
