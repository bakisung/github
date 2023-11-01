package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// 아래와 같이 스프링 실행 어노테이션 옆에 exclude = {SecurityAutoConfiguration.class}를 등록하면 스프링 자체적으로 구현되어 있는 로그인 페이지로 이동되지 않는다.
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PersonalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalProjectApplication.class, args);
		System.out.println("Server Start");
	}

}
