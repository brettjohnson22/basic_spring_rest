package com.simpler.testapi.controller;

import java.util.List;

import com.simpler.testapi.data.models.Employee;
import com.simpler.testapi.service.EmployeeService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/protected")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/employees")
    public List<Employee> findallEmployees(){
        return service.getEmployees();
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/employeeById/{id}")
    public Employee findEmployeeById(@PathVariable Integer id){
        return service.getEmployeeById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/employeeByName/{name}")
    public Employee findEmployeeByName(@PathVariable String name){
        return service.getEmployeeByName(name);
    }

}
