package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
