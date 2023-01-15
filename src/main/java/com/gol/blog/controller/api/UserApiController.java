package com.gol.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gol.blog.dto.ResponseDto;
import com.gol.blog.model.RoleType;
import com.gol.blog.model.User;
import com.gol.blog.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserApiController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
//	@Autowired 기본으로 선언해서 사용 가능
//	private HttpSession session;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("회원가입 호출됨");
		user.setRole(RoleType.USER);
		userService.회원가입(user);
		System.out.println("회원가입 호출됨2");
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user, HttpSession session) {
		System.out.println("회원수정 호출됨");
		userService.회원수정(user);
		System.out.println("회원수정 호출됨2");
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//		System.out.println("로그인 호출됨");
//		User principal = userService.로그인(user);
//		
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//		}
//		return new ResponseDto<Integer>(HttpStatus.BAD_REQUEST.value(), 1);
//	}
}
