package com.example.spring_jdbc.controller;

import com.example.spring_jdbc.dao.UserRepoImpl;
import com.example.spring_jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepoImpl userRepoImpl;
    @Autowired
    public UserController(UserRepoImpl userRepoIm)
    {
        userRepoImpl=userRepoIm;
    }

    @PostMapping("/save")
    public User saveuser(@RequestBody User user)
    {
        return userRepoImpl.saveuser(user);
    }
    @PutMapping("/update")
    public User update(@RequestBody User user)
    {
        return userRepoImpl.updateuser(user);
    }

    @GetMapping("/list")
    public List<User> listall()
    {
        return userRepoImpl.allusers();
    }

    @GetMapping("/{id}")
    public User getByid(@PathVariable("id") int id)
    {
        return userRepoImpl.getbyid(id);
    }

    @DeleteMapping("/{id}")
    public String deletebyID(@PathVariable int id)
    {
        User user=userRepoImpl.getbyid(id);
        userRepoImpl.deletebyid(id);
        return "deleted user "+user.getId();
    }


}
