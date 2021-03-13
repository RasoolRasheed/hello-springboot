package com.rasool.test.auth;

import com.rasool.test.exceptions.JwtAuthenticationException;
import com.rasool.test.model.Student;
import com.rasool.test.model.User;
import com.rasool.test.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


import java.util.List;
import javax.servlet.ServletRequest;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
	private final JwtService jwtService;
	public ServletRequest request;

    @SuppressWarnings("unused")
    public JwtAuthenticationProvider() {
        this(null,null);
    }

    @Autowired
    public JwtAuthenticationProvider(JwtService jwtService, ServletRequest request) {
        this.jwtService = jwtService;
        this.request = request;
    }
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {	        
	        List<Object> jwtDataList = jwtService.verify((String) authentication.getCredentials());
            User possibleProfile = (User)jwtDataList.get(0);
            if(possibleProfile!=null){
            	//request.setAttribute("user", possibleProfile);
            }
            return new JwtAuthenticatedProfile(possibleProfile);
	        
        } catch (Exception e) {
            throw new JwtAuthenticationException("Failed to verify token", e);
        }
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthToken.class.equals(authentication);
    }
}
