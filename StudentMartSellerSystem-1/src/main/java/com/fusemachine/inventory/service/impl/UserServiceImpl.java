package com.fusemachine.inventory.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fusemachine.inventory.service.UserService;
import com.fusemachine.inventory.repository.UserRepository;
import com.fusemachine.inventory.domain.User;
@Service
@Primary
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	 @Override
	 public User findUserByEmailID(String emailID) 
	 {
		 return userRepository.findByEmailID(emailID);
	 }
	 
	 @Override
	 public void saveUser(User user) 
	 {
		  //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		  //user.setActive(1);
		  //Role userRole = roleRespository.findByRole("ADMIN");
		  //user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		  userRepository.save(user);
	 }

}
