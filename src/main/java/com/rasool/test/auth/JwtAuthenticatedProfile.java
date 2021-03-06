package com.rasool.test.auth;

import com.rasool.test.model.Student;
import com.rasool.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class JwtAuthenticatedProfile implements Authentication {
	
	@Autowired
	private User user;
	
	public JwtAuthenticatedProfile(User user) {
		this.user = user;
	}
	
	
	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	@Override
	public Object getCredentials() {
		return null;
	}
	
	@Override
	public Object getDetails() {
		return null;
	}
	
	@Override
	public Object getPrincipal() {
		return null;
	}
	
	@Override
	public boolean isAuthenticated() {
		return false;
	}
	
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		
	}
}