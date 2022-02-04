package com.business.demo.aplication.repository;

import com.business.demo.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Override
    Optional<Employee> findById(Integer id);
    Optional<Employee> findByName(String name);
    Optional<Employee> findByCode(Integer code);
    Employee save(Employee employee);
    void delete(Employee employee);
}
