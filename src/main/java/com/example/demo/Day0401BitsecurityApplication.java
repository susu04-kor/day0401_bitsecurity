package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVo;

@SpringBootApplication
public class Day0401BitsecurityApplication {

	//패스워드 암호화를 위한 객체를 생성해요	//PasswordEncoder - 인터페이스
	@Bean   //어노테이션
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//패스워드를 생성해주는 클래스 - PasswordEncoderFactories
		//패스워드를 암호화해주는 객체 제공 - createDelegatingPasswordEncoder()
		//passwordEncoder()메소드를 찾아서 내부적으로 암호화 처리 해주기 때문에 반드시 이 이름으로 id를 만들어줘야 함
	}

	public static void main(String[] args) {
		
		//두명의 회원 추가
//		DBManager.insertMember(new MemberVo("tiger", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("tiger"), "홍길동", "user"));	//id: tiger, 암호: tiger 이름: 홍길동, role: 일반유저
//		DBManager.insertMember(new MemberVo("master", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"), "곽동길", "ADMIN"));	//id: master, 암호: 1234  이름: 곽동길, role: ADMIN
		//그런데 이렇게 암호를 쌩으로 넣으면 DB에 안 들어감
		//암호화!  - 위에 만들어놓은 passwordEncoder()메소드 호출!
		
	
		SpringApplication.run(Day0401BitsecurityApplication.class, args);
	}
}
