package com.example.demo;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVo;

@Service//이 클래스는 자동으로 스캔돼야 하니까 메인서버 있는 demo 패키지에 만들기 / @service 붙여야 자동 스캔됨
public class MemberService implements UserDetailsService {

	@Override		//클래스 만들 때 add 눌러서 UserDetailsService 검색하여 finish하면
					//이 메소드가 자동으로 override 해줌
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//매개변수로 전달받은 username에 해당하는
		//회원의 정보를 db로부터 꺼내와요
		MemberVo m = DBManager.selectMember(username);
		
		//만약 username(id)에 해당하는 회원이 없으면 예외 발생시켜요
		
		if(m==null) {	//throw = 예외 강제 발생 메소드
			throw new UsernameNotFoundException(username);
		}
		
		//우리가 db로 부터 뽑아온 회원의 정보를
		//스프링 시큐리티가 인증절차를 진행할 수 있는 객체로 만들어서 일을 맡깁니다
		
		//객체 생성해서 반환하기 
		return User.builder()
				.username(username)		//username은 이렇게 할게요
				.password(m.getPwd())	//비밀번호는 이렇게 받을게요
				.roles(m.getRole())		//권한은 이렇게 할게요
				.build();				//생성합니다
	
	}

}
