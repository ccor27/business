package com.business.demo.infrastructure.api;

import com.business.demo.aplication.service.EmployeeService;
import com.business.demo.domain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @GetMapping("/get/id/{id}")
    public Optional<Employee> findById(@PathVariable("id") Integer id){
        return employeeService.findById(id);
    }
    @GetMapping("/get/code/{code}")
    public Optional<Employee> findByCode(@PathVariable("code") Integer code){
        return employeeService.findByCode(code);
    }
    @GetMapping("/get/name/{name}")
    public Optional<Employee> findByName(@PathVariable("name") String name){
        return employeeService.findByName(name);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        if(!findById(id).isPresent()){
            throw new IllegalStateException("the employee no exits");
        }
        employeeService.delete(findById(id).get());
    }
}
