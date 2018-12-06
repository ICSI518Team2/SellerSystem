package com.fusemachine.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.domain.User;

public interface UserRepository extends  JpaRepository<User,Integer>{
	public User findByEmailID(String emailID);
}
