package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.MemberVo;

@Controller			//@RestController에서 @Controller로 변경
public class IndexController {
	
	@GetMapping("/")	// "/"-루트
	public String index(Model model) {
		model.addAttribute("m", new MemberVo("tiger","1234","홍길동","user")); //상태유지 된 것
		return "index";
	}

	//만약에 vo로 강제로 안 담고 db 가져오려면 2번째에 dao.listAll 같은 거 해주기 
	//그리고 m 대신에 다른 변수명 설정
	//return에는 /경로+/html이름!
	//그러려면 controller로!
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	
}
