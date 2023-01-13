package com.gol.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {
	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("TEMP HOME");
//		파일 리턴 기본 경로: /src/main/resources/static
//		리턴명: /home.html
//		전체경로: /src/main/resources/static/home.html
		return "/home.html";
	}
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		System.out.println("TEMP JSP");
//		파일 리턴 기본 경로: /src/main/resources/static
//		리턴명: /home.html
//		전체경로: /src/main/resources/static/home.html
		return "/test";
	}
}
