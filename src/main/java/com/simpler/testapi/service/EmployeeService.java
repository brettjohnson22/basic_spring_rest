package com.simpler.testapi.service;

import java.util.ArrayList;
import java.util.List;

import com.simpler.testapi.data.models.Employee;
import com.simpler.testapi.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
  
    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }


}