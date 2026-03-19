package com.cdsc.spirngmvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdsc.spirngmvcdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String un, String psw);
}
