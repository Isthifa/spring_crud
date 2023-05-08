package com.example.spring_hibernate.service;

import com.example.spring_hibernate.entity.Employee;
import com.example.spring_hibernate.repositroy.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeImpl(EmployeeRepo employeeRepo)
    {
        this.employeeRepo=employeeRepo;
    }
    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> emplist() {
        List<Employee> employees=employeeRepo.findAll();
        return employees;
    }


    @Override
    public void delete(long id) {

        employeeRepo.deleteById(id);
    }

    @Override
    public Employee findbyId(long id) {
        return employeeRepo.findById(id).orElseThrow(()->new RuntimeException("not found "+id));
    }
}
