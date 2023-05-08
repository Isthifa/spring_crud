package com.example.springdata_jpa.controller;

import com.example.springdata_jpa.entity.Student;
import com.example.springdata_jpa.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Student student)
    {
        Student student1=studentService.save(student);
        return new ResponseEntity(student1,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,@RequestBody Student student)
    {
        Optional<Student> studen=studentService.findByid(id);
        Student student1=studen.get();
        student1.setName(student.getName());
        student1.setEmail(student.getName());
        studentService.save(student);
        return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public List<Student> listall()
    {
       List<Student> students=studentService.listall();
       return students;
    }
    @GetMapping("/{id}")
    public Optional<Student> findbyid(@PathVariable long id)
    {
        Optional<Student> student=studentService.findByid(id);
        return student;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id)
    {
        studentService.deleteById(id);
        return "Deleted "+id;
    }
}
