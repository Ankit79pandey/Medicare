package com.application.demo.signup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class SignUpController {
	
	@Autowired
	private SignUpService service;
	

	@PostMapping("/")
	public ResponseEntity<SignUp> addUser(@RequestBody SignUp signup){
		SignUp user= service.addAuthor(signup);
		if(user!=null)  
			return new ResponseEntity<SignUp>(user,HttpStatus.CREATED);
		else
			return new ResponseEntity<SignUp>(user, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("/GetUser")
	public List<SignUp>getAllUsers(){
		return service.UserAccessessibility();
	}
	
	
//	@GetMapping("/")
//	public  List<SignUp> getAllUser(){
//		return service.getAll();
//	}
	
	@GetMapping("signup/{id}")
	public ResponseEntity<SignUp> getUserById(@PathVariable int id){
		  SignUp user= service.getUserById(id);
		  
		  if(user!=null)
			  return new ResponseEntity<SignUp>(user,HttpStatus.FOUND);
		  else
			  return new  ResponseEntity<SignUp>(user,HttpStatus.NOT_FOUND);
	}
}
