package com.cos.securityex01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //IOC 빈(bean = 객체) 을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션 (시큐리티 필터체인을 전체적으로 관리 할수있다.)
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소 접근시 (컨트롤러 접근전에) 권한 및 인증을 미리 체크  
public class SecurityConfig extends WebSecurityConfigurerAdapter{ //원하는것만 오버라이딩해서 관리가능
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user/**","/admin/**") // 잠궈야할것을 설정한다.
			.authenticated()
			.anyRequest()
			.permitAll()
		.and()
			.formLogin()
			.loginPage("/login"); // '/user', '/admin' 을 login페이지로 연결되도록 한다.
	}
	
}
