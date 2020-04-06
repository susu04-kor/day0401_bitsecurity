package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	
	@GetMapping("/all/list")	//all이라는 네임스페이스를 달고 오는 것은 로그인 안해도 아무나 사용할 수 있어요
	public String list() {	//아무나
		return "list";
	}
	
	@GetMapping("/admin/cmd1")	//admin만
	public String cmd1() {//admin이라는 네임스페이스를 달고 오는 것은 로그인 해야하고 
						//권한이 있는 사람(admin)만이 access하고 서비스를 사용할 수 있어요 
						//-> 그런데이걸 위한 환경설정을 또 해줘야 함
						//아직은 http://localhost:8088/admin/cmd1 이렇게 치면 누구나 들어갈 수 있음 
		return "서비스1";
	}
	
	@GetMapping("/insert")	//로그인한 사람!
	public String insert() {
		return "insert";
	}
	
}
