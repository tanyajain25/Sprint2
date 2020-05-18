package org.cap.usermngt.service;

import java.math.BigInteger;
import java.util.List;
import org.cap.usermngt.entities.User;

public interface UserService {

	User addUser(User user);

	User viewUser(BigInteger id);

	List<User> viewAllUsers();

	Boolean deleteUser(BigInteger id);

	User updateUser(User user);
}
