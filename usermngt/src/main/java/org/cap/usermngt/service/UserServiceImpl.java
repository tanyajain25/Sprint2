package org.cap.usermngt.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.cap.usermngt.dao.UserDao;
import org.cap.usermngt.entities.User;
import org.cap.usermngt.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* add new user */
	@Override
	public User addUser(User user) {
		user = userDao.save(user);
		return user;
	}

	/* view user using userId */
	@Override
	public User viewUser(BigInteger id) {
		Optional<User> optional = userDao.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			return user;
		}
		throw new UserNotFoundException("User not found for id=" + id);
	}

	/* view all users */
	@Override
	public List<User> viewAllUsers() {
		List<User> list = userDao.findAll();
		return list;
	}

	/* delete user */
	@Override
	public Boolean deleteUser(BigInteger userId) {
		Optional<User> optional = userDao.findById(userId);
		if (optional.isPresent()) {
			userDao.deleteById(userId);
			return true;
		}
		throw new UserNotFoundException("User not found for id=" + userId);

	}

	/* update user */
	@Override
	public User updateUser(User user) {
		user = userDao.save(user);
		return user;
	}
}
