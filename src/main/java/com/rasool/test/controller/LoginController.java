package com.rasool.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rasool.test.dto.LoginDTO;
import com.rasool.test.dto.LoginResponse;
import com.rasool.test.dto.ValidationError;
import com.rasool.test.model.User;
import com.rasool.test.repository.UserRepository;
import com.rasool.test.service.JwtService;
import com.rasool.test.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins="*")
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Environment env;
	@Autowired
	private JwtService jwtService;
	
	@PostMapping
	public LoginResponse authenticate(ServletRequest request, @RequestBody LoginDTO loginDTO, HttpServletResponse resp){
		LoginResponse  response = new LoginResponse();
		List<ValidationError> errorList = new ArrayList<ValidationError>();
		PasswordService ps = new PasswordService();
		
		System.out.println("### PW: " + ps.encrypt(loginDTO.getPassword()));
		
		try {
			User user = userRepository.findByUsername(loginDTO.getUsername());
			if (user != null) {
				System.out.println(ps.decrypt(user.getPassword()));

				//if (user.getStatus().equals(RecordStatusEnum.ACTIVE.getCode())) {
					if (ps.decrypt(user.getPassword()).equals(loginDTO.getPassword())) {
						
						String accessToken = jwtService.tokenFor(user);
						resp.setHeader("Token", accessToken);
						System.out.println(accessToken);
						//save user log
						/*UserLog userLog = new UserLog();
						userLog.setUser(user);
						userLog.setLoggedDate(new Date());
						userLogRepository.save(userLog);*/

						response.setCode(200); // success
						response.setName(user.getName());
						response.setToken(accessToken);
					}else{
						/*response.setCode(ResponseEnum.PASSWORD_INCORRECT.getCode());
						response.setMessage(ResponseEnum.PASSWORD_INCORRECT.getDescription());*/
					}
				/*}else{
					response.setCode(ResponseEnum.INACTIVE_LOGIN.getCode());
					response.setMessage(ResponseEnum.INACTIVE_LOGIN.getDescription());
				}*/
			}else{
				/*response.setCode(ResponseEnum.USERNAME_NOT_FOUND.getCode());
				response.setMessage(ResponseEnum.USERNAME_NOT_FOUND.getDescription());*/
			}
		} catch (Exception e) {
			response.setMessage(e.getMessage());
		}
		response.setValidationErrors(errorList);
		return response;		
	}

	@GetMapping("/home")
	public String home(Map<String, Object> model) {
		model.put("message", "HowToDoInJava Reader !!");
		return "index";
	}
}