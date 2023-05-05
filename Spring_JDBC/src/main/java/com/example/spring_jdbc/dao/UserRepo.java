package com.example.spring_jdbc.dao;

import com.example.spring_jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements UserRepoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public User saveuser(User user) {
        String query="INSERT INTO user(id,name,email) values(?,?,?)";
        jdbcTemplate.update(query,user.getId(),user.getName(),user.getEmail());
        return user;
    }

    @Override
    public int deletebyid(int id) {
        String query="Delete from user where id=?";
        return jdbcTemplate.update(query,id);
    }

    @Override
    public User getbyid(int id) {
        String get="Select * from user where id=?";
        return jdbcTemplate.queryForObject(get,(rs, rowNum) -> new User(rs.getInt("id"),rs.getString("name"),rs.getString("email")),id);
    }

    @Override
    public User updateuser(User user) {
        String query="Update user set name=?,email=? where id=?";
        jdbcTemplate.update(query,user.getName(),user.getEmail(),user.getId());
        return user;
    }

    @Override
    public List<User> allusers() {

        String list="Select * from user";
        return jdbcTemplate.query(list,(rs, rowNum) -> new User(rs.getInt("id"),rs.getString("name"),rs.getString("email")));
    }
}
