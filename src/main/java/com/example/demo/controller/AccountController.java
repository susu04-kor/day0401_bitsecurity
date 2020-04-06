package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DBManager;
import com.example.demo.vo.TransferVo;

@RestController
public class AccountController {
	
	@GetMapping("/transfer")
	public String transfer(TransferVo t) {
		String str = "ok";
		DBManager.transfer(t);
		
		return str;
	}
}
