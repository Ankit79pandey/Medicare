package com.application.demo.signup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SignUpService {

	@Autowired
	private SignUpRepo repository;
	
	public SignUp addAuthor(SignUp Model) {
		// TODO Auto-generated method stub
		return repository.save(Model);
	}



	public SignUp getUserById(int id) {
		// TODO Auto-generated method stub
		if(repository.findById(id).isPresent()) 
			return repository.findById(id).get();
		else 
			return null;
	}



	public List<SignUp> UserAccessessibility() {
		// TODO Auto-generated method stub
	
		System.out.println(repository.findAll());
		return repository.findAll();
	}

	

}
