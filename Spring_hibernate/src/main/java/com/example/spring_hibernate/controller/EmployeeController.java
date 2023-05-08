package com.example.spring_hibernate.controller;

import com.example.spring_hibernate.entity.Employee;
import com.example.spring_hibernate.entity.EmployeeDetails;
import com.example.spring_hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
    @PutMapping("/update/{id}")
    public Employee update(@RequestBody Employee employee,@PathVariable long id)
    {
        Employee employee1=employeeService.findbyId(id);
        if(employee1==null)
        {
            throw new RuntimeException("not found");
        }
        else {
            employee1.setEmpid(employee.getEmpid());
            employee1.setEmpname(employee.getEmpname());
            employee1.setEmpsalary(employee.getEmpsalary());
            employee1.setEmpdesignation(employee.getEmpdesignation());
            employee1.setEmployeeDetails(employee.getEmployeeDetails());
            EmployeeDetails employeeDetails=employee1.getEmployeeDetails();
            employeeDetails.setId(employeeDetails.getId());
            employeeDetails.setAddress(employeeDetails.getAddress());
            employeeDetails.setAddress(employeeDetails.getAddress());
            employeeService.save(employee1);
        }
        return employee;
    }

    @GetMapping("/{id}")
    public Employee findbyid(@PathVariable long id)
    {
        Employee employee=employeeService.findbyId(id);
        return employee;
    }
    @GetMapping("/list")
    public List<Employee> listall()
    {
        List<Employee> employees=employeeService.emplist();
        return employees;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Employee emp = employeeService.findbyId(id);
        if (emp == null) {
            throw new RuntimeException("not found");
        } else {
            employeeService.delete(id);
        }
    }
}
