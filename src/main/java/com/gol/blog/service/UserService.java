package com.gol.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gol.blog.model.User;
import com.gol.blog.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		userRepository.save(user);
	}
//	@Transactional(readOnly = true) //Select할때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
	@Transactional
	public void 회원수정(User user) {
		
		User updatedUser =userRepository.findById(user.getId())
		.orElseThrow(() -> {
			return new IllegalArgumentException("회원찾기 실패: 아이디를 찾을수 없습니다.");
		});
		
		updatedUser.setPassword(encoder.encode(user.getPassword()));
		updatedUser.setEmail(user.getEmail());
	}
}
