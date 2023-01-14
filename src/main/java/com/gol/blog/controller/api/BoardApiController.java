package com.gol.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gol.blog.config.auth.PrincipalDetail;
import com.gol.blog.dto.ResponseDto;
import com.gol.blog.model.Board;
import com.gol.blog.model.RoleType;
import com.gol.blog.model.User;
import com.gol.blog.service.BoardService;
import com.gol.blog.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class BoardApiController {
	@Autowired
	private BoardService boardService;
	

	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		System.out.println("글쓰기가 호출됨");

		boardService.글쓰기(board, principal.getUser());
		System.out.println("글쓰기가 호출됨2");
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
