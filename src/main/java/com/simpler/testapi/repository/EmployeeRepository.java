package com.simpler.testapi.repository;

import java.util.Optional;

import com.simpler.testapi.data.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    public Optional<Employee> findByName(String name);
}
