package com.fdmgroup.UserSystem.Service;
import org.springframework.stereotype.Service;

import com.fdmgroup.UserSystem.Exception.UsernameException;
import com.fdmgroup.UserSystem.Model.User;
import com.fdmgroup.UserSystem.Rep.UserSystemRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImplementation implements UserService{
	
	private UserSystemRepository userSystemRepository;
	
	public UserServiceImplementation (UserSystemRepository userSystemRepository) {
		this.userSystemRepository= userSystemRepository;
	}
	
	@Override
	public User createUser(User user) {
		if (this.userSystemRepository.findByUsername(user.getUsername()) == null){
		 return this.userSystemRepository.save(user);
		} else {
			throw new UsernameException("Title " + user.getUsername()+ "Already in use");
		}
	}

	@Override
	public User findUserByid(long id) {
		return this.userSystemRepository.findById(id).orElse(null);
	}

	@Override
	public User findUserByUsername(String username) {
		return this.userSystemRepository.findByUsername(username);
	}

	@Override // updates with the presence of an id
	public User updateUser(User user) {
		return this.userSystemRepository.save(user);
	}

	@Override
	public User deleteUserByUsername(String username) {
		return this.userSystemRepository.deleteUser(username);
	}

	
}
