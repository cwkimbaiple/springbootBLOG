package com.gol.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gol.blog.model.User;

public class PrincipalDetail implements UserDetails {
	

	public PrincipalDetail(User user) {
		this.user = user;
	}

	private User user;
	
	// 계정의 권한목록을 리턴한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> collectors = new ArrayList<>();
//		collectors.add(new GrantedAuthority() {
//			
//			@Override
//			public String getAuthority() {
//				return "ROLE_"+user.getRole();
//			}
//		});
		
		collectors.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
		
		return collectors;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

//계정이 만료되지  않은지 리턴한다.(true:만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있지 않은지 리턴한다.(true:잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

//비밀번호 만료(true: 만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

//계정활성화
	@Override
	public boolean isEnabled() {
		return true;
	}

}
