package com.gol.blog.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gol.blog.model.User;


//DAO
// 자동으로 bean등록이 된다.
// 그래서 @Repository 생략이 가능하다.
public interface  UserRepository extends JpaRepository<User, Integer>{
//	JPA Naming 전략
	//SELECT * FROM user WHERE username=?1 AND password=?2
//	User findByUsernameAndPassword(String username, String password);
	
//	@Query("SELECT * FROM user WHERE username=?1 AND password=?2", nativeQuery = true )
//	User login(String username, String password);
	
	Optional<User> findByUsername(String username);
	
}
