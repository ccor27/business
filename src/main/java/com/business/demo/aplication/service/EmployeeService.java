package com.business.demo.aplication.service;

import com.business.demo.aplication.repository.EmployeeRepository;
import com.business.demo.domain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> findById(Integer id){
        if(!employeeRepository.findById(id).isPresent()){
            throw new IllegalStateException("Employee not found by id");
        }
        return employeeRepository.findById(id);
    }

    public Optional<Employee> findByName(String name){
        if(!employeeRepository.findByName(name).isPresent()){
            throw new IllegalStateException("Employee not found by name");
        }
        return employeeRepository.findByName(name);
    }

    public Optional<Employee> findByCode(Integer code){
        if(!employeeRepository.findByCode(code).isPresent()){
            throw new IllegalStateException("Employee not found by code");
        }
        return employeeRepository.findByCode(code);
    }
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }
}
