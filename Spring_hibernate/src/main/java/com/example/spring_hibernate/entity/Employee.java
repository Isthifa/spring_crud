package com.example.spring_hibernate.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empid;
    private String empname;
    private String empsalary;
    private String empdesignation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="empid")
    private EmployeeDetails employeeDetails;


}
