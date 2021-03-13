package com.rasool.test.service;

import com.rasool.test.exceptions.JwtAuthenticationException;
import com.rasool.test.model.User;
import com.rasool.test.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.time.ZoneOffset.UTC;

@Component
public class JwtService {
    private static final String ISSUER = "test";
    public static final String USERNAME = "razool";
    public static final String encodedKey = "jwtKey";
    public static final int expirationHours = 2;

    private final User user;

    public JwtService(User user) {
		this.user = user;
	}

	@Autowired(required = true)
    UserRepository userRepository;

    public String tokenFor(User user) throws IOException, URISyntaxException {
        Date expiration = Date.from(LocalDateTime.now(UTC).plusHours(expirationHours).toInstant(UTC));
        return Jwts.builder()
        		.claim("userId", user.getUserId())
                .setExpiration(expiration)
                .setIssuer(ISSUER)
                .signWith(SignatureAlgorithm.HS512, encodedKey.getBytes())
                .compact();
    }

    public List<Object> verify(String token) throws IOException, URISyntaxException{
    	List<Object> responseObjList = new ArrayList<Object>();
    	try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(encodedKey.getBytes()).parseClaimsJws(token);
            Optional<User> user = userRepository.findById(Long.parseLong(claims.getBody().get("userId").toString()));
	        responseObjList.add(user.get());
		} catch (Exception exception) {
			throw new JwtAuthenticationException("Failed to return token token", exception);
		}
    	return responseObjList;
    }
}