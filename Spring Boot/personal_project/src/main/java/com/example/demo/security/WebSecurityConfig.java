package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity.csrf().disable()	// CSRF 공격에 대한 방어 해제
				.authorizeRequests()	//URI에 따른 페이지에 대한 권한을 부여하기 위해 시작하는 메소드
				.antMatchers("/user/**")	// 특정 URL 접근 시 인가가 필요한 URI 설정
				.authenticated()	// 해당 URI는 인증이 필요한 URI라고 명시
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
				.anyRequest().permitAll()	// 특정 URI를 제외한 나머지 URI는 전부 인가
				.and()
				.formLogin()	// 아이디와 비밀번호를 입력해서 들어오는 로그인 형태를 지원하는 기능(loginPage() 메소드를 사용할 수 있도록 한다.)
				.loginPage("/login")	// 로그인 페이지 설정(로그인 하지 않은 경우 허용되지 않는 페이지 접속 시 로그인 페이지로 redirect 한다.
				.loginProcessingUrl("/loginproc")	// formLogin의 자동 로그인 방식을 이용한다. username과 password를 해당 경로에 던져주면 자동으로 로그인 된다.
				.defaultSuccessUrl("/")	// 로그인을 성공했을때의 기본 url을 설정
				.and()
				.build();

	}

}
