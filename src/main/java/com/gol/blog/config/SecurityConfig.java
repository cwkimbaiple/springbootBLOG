package com.gol.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gol.blog.config.auth.PrincipalDetailService;

import lombok.AllArgsConstructor;

//@Configuration
//@RequiredArgsConstructor
@Configuration
@EnableWebSecurity // 시큐리티에 필터로 등록이 된다.
@EnableMethodSecurity(prePostEnabled=true) // 특정주소로 접근하면 권한 및 인증을 미리 첵크하겠다는 뜻.
@AllArgsConstructor

public class SecurityConfig {

		@Autowired
		private PrincipalDetailService principalDetailService;
	
		@Bean
		public BCryptPasswordEncoder encodePWD() {
			return new BCryptPasswordEncoder();
		}
		
		@Bean
		public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		    return authenticationConfiguration.getAuthenticationManager();
		}

		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
		}
	
	    @Bean
	    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

	        http.authorizeHttpRequests()
            	.requestMatchers("/")
            	.authenticated()
            	.anyRequest().permitAll()
            .and()
            	.csrf().disable()
            	.formLogin()
            	.loginPage("/auth/loginForm")
            	.loginProcessingUrl("/auth/loginProc")
            	.defaultSuccessUrl("/"); //스프링 시큐리티가 로그인을 가로챈다. 
	        

    return http.build();
	    }
}