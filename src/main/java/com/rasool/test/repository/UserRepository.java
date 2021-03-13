package com.rasool.test.repository;

import com.rasool.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByNic(String nic);

	public User findByUserId(long userId);

	public User findByUsername(String username);
	
	public User findByUsernameAndStatus(String username, String status);
}
