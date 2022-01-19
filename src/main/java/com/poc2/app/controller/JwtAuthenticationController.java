package com.poc2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc2.app.model.JwtRequest;
import com.poc2.app.model.JwtResponse;
import com.poc2.app.model.Student;
import com.poc2.app.security.JwtTokenUtil;
import com.poc2.app.service.StudentDetailsService;


//
//import com.neosoft.config.JwtTokenUtil;
//import com.neosoft.model.JwtRequest;
//import com.neosoft.model.JwtResponse;
//import com.neosoft.model.UserDTO;
//import com.neosoft.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private StudentDetailsService studentDetailsService;

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = studentDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("JWT Token : "+token);
//		boolean validate = jwtTokenUtil.validateToken(token, userDetails);
//		if(validate) return "redirect:/viewcars";
//		else return "redirect:/login";
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@PostMapping("/insert/student")
	public Student insertStudent(@RequestBody Student student) {
		return studentDetailsService.save(student);
	}
	
	

	private void authenticate(String username, String password) throws Exception {
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}