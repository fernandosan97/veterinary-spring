package com.veterinary.veterinary.controllers;

import com.veterinary.veterinary.models.TokenModel;
import com.veterinary.veterinary.models.UserModel;
import com.veterinary.veterinary.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ArrayList<UserModel> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/login")
	public TokenModel login(@RequestParam("username") String username, @RequestParam("password") String password) {
		UserModel user = new UserModel();
		user.setUser(username);
		user.setPwd("");

		TokenModel objToken = new TokenModel();

		try {
			UserModel userDB = userService.login(user);

			if(!userDB.getUser().isEmpty()){
				// Verify password
				boolean passwordMatch = BCrypt.checkpw(password, userDB.getPwd());

				if(passwordMatch) {
					// Setting token to return it
					objToken.setToken(getJWTToken(userDB.getUser()));
					objToken.setStatus(HttpStatus.OK);
				}else{
					throw new Exception();
				}
			}else {
				throw new Exception();
			}
		} catch(Exception e) {
			objToken.setToken("There's no token");
			objToken.setStatus(HttpStatus.BAD_REQUEST);
		}

		return objToken;
	}

	@PostMapping("/user")
	public TokenModel register(@RequestParam("username") String username, @RequestParam("password") String password) {
		TokenModel objToken = new TokenModel();

		try{
			// Instance of User
			UserModel user = new UserModel();
			user.setUser(username);
			user.setPwd(password);
			userService.saveUser(user);

			// Setting token to return it
			objToken.setToken(getJWTToken(user.getUser()));
			objToken.setStatus(HttpStatus.OK);
		}catch(Exception e) {
			objToken.setToken("There's no token");
			objToken.setStatus(HttpStatus.BAD_REQUEST);
		}

		return objToken;
	}

	private String getJWTToken(String username) {
		String secretKey = "mitoken.secreto.springboot";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
