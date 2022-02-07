package com.simpler.testapi.repository;

import com.simpler.testapi.data.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
