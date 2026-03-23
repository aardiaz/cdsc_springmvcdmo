package com.cdsc.spirngmvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdsc.spirngmvcdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String un, String psw);
	
	//using JPQL
	//@Modifying // for update query
	@Query("SELECT u FROM User u WHERE u.username= ?1 AND u.password= ?2")
	User userExistForLogin(String un, String psw);
	
	//using SQL
	@Query(value = "select * from user_tbl where username= :un and password= :psw", nativeQuery = true)
	User checkUser(@Param("un") String un, @Param("psw")String psw);
	
}
