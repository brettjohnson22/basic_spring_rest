package com.simpler.testapi.controller;

import java.util.List;

import com.simpler.testapi.data.models.Employee;
import com.simpler.testapi.service.EmployeeService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> findallEmployees(){
        return service.getEmployees();
    }

    
}
