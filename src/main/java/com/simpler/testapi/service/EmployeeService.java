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

    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeeById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public void deleteEmployee(Integer id){
        repository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee){
        Employee employeeFromDb = repository.findById(employee.getId()).orElse(null);
        employeeFromDb.setName(employee.getName());
        return repository.save(employeeFromDb);
    }
    
    public Employee getEmployeeByName(String name){
        Employee employeeFromDb = repository.findByName(name).orElse(null);
        return employeeFromDb;
    }

}
