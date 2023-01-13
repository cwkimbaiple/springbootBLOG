package com.gol.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gol.blog.model.RoleType;
import com.gol.blog.model.User;
import com.gol.blog.repository.UserRepository;

import jakarta.transaction.Transactional;

@RestController
public class DummyControllerTest {
	
	@Autowired //의존성 주입
	private UserRepository userRepository;

	//http://localhost:8000/blog/dummy/users
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	//http://localhost:8000/blog/dummy/user/id
	@Transactional //자동 commit를 실행함으로 따로 userRepository.save(user);를 실행할 필요가 없다.
	@PutMapping("/dummy/user/{id}")
	public User update(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("password: "+requestUser.getPassword());
		System.out.println("email: "+requestUser.getEmail());
		System.out.println("id: "+id);
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		
		user.setEmail(requestUser.getEmail());
		user.setPassword(requestUser.getPassword());
		
		//userRepository.save(user);
		return user;
	}
	
	//http://localhost:8000/blog/dummy/user/3
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);	
		}catch(EmptyResultDataAccessException e){
			return "삭제에 실패하였습니다. 해당 ID는 DB에 없습니다. ID는 "+id;
		}
		return "삭제되었습니다.";
	}
	
	//http://localhost:8000/blog/dummy/user?page=0
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
		List<User> users = userRepository.findAll(pageable).getContent();
		return users;
	}
	
	//http://localhost:8000/blog/dummy/user/id
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		//user를 못찾으면 null이므로 빈 user로 만들어서 가지고옴.
		//람다식
//		User user = userRepository.findById(id).orElseThrow(()->{
//			return new IllegalArgumentException("해당사용자는 없습니다. 람다식");
//		});
				
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id: "+id);
			}
		});
		return user;
	}
	
	
//http://localhost:8000/blog/dummy/join
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email: "+user.getEmail());
		System.out.println("role: "+user.getRole());
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
}
