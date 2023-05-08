package com.example.spring_hibernate.service;

import com.example.spring_hibernate.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> emplist();
    void delete(long id);
    Employee findbyId(long id);

}
