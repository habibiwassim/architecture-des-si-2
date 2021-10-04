package tn.esprit.esponline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.esponline.repository.IUserRepository;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserRepository userRepository;
	
	public IUserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
