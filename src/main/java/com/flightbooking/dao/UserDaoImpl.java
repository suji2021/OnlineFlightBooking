package com.flightbooking.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.model.User;
import com.flightbooking.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	
	public User registerUser(User user) {		
		return repository.save(user);
	}


	
	public void deleteUser(long userId) throws UserNotFoundException{
		User usr= repository.getOne(userId);
		if(usr==null) {
			throw new UserNotFoundException();
		}
		else {
			repository.delete(usr);
		}
	}

	
	public User getUserById(long userId) throws UserNotFoundException {
		User usr;
		if(repository.findById(userId).isEmpty()) {
			throw new UserNotFoundException();
		}
		else {
			usr=repository.findById(userId).get();
		}
		return usr;
	}


	
	public String loginUser(User user) throws UserNotFoundException {
		if(repository.validateUser(user.getEmailId(),user.getPassword()).isEmpty())
			{
				throw new UserNotFoundException("Invalid User");
			}
		return "Login Successful";
	}

	
	public User updateUser(User user, long userId) throws UserNotFoundException {
		User u =repository.findById(userId).get();
		if(u==null) {
			throw new UserNotFoundException();
		}		
		u.setAddress(user.getAddress());
		u.setMobile(user.getMobile());
		return this.repository.save(u);
	}

	
	
}
	
