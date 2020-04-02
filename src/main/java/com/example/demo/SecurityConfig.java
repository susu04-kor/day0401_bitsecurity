package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 			//(1) 자동으로 스캔되어야 해서 configuration 설정
@EnableWebSecurity		//(2)어노테이션 기반의 시큐리티 설정임을 나타냅니다
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override    //(3)우클릭 - source- override - configure(HttpSecurity http) 클릭
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		//모든 설정을 http를 매개변수로 받아서 하면 됨
		//(4)
		http.authorizeRequests()	//사용자의 요청별 권한 설정을 하겠습니다
		.mvcMatchers("/","/all/**").permitAll()	//어떤 패턴에 대해서 어떤 권한이 있는 사람이 access할 건지	// "/"- 루트에 있는 요청과 /all/** - all에 있는 모든 요청은 아무나 사용할 수 있어요
		.mvcMatchers("/admin/**").hasRole("ADMIN") //admin에 있는 모든 요청은 권한(ADMIN이라는 권한)이 있어야 사용가능해요 => role 설정: 인가!!
		.anyRequest().authenticated(); // 그 나머지 요청은 로그인만 즉, 인증만 하면 서비스 이용 가능해요
		
		http.formLogin();	//formlogin 형식을 사용할겁니다
		http.httpBasic();	//나머지는 basic을 따르겠습니다.
		
	}
	
	
}
