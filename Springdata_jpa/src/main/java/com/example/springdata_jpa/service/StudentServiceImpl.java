package com.example.springdata_jpa.service;

import com.example.springdata_jpa.dao.StudentDAO;
import com.example.springdata_jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    public StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO)
    {
        this.studentDAO=studentDAO;
    }
    @Override
    public List<Student> listall() {
        return studentDAO.findAll();
    }

    @Override
    public Student save(Student student)
    {
        return studentDAO.save(student);
    }


    @Override
    public void deleteById(long id) {
        studentDAO.deleteById(id);
    }

    @Override
    public Optional<Student> findByid(long id) {
        Optional<Student> student= studentDAO.findById(id);
        if(!student.isPresent())
        {
            throw new RuntimeException("Not found");
        }
        else
        {
            return student;
        }
    }

}
