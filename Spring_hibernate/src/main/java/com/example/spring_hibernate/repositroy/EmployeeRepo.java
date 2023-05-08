package com.example.spring_hibernate.repositroy;

import com.example.spring_hibernate.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;


public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
