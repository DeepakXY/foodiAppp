package niit.jdp.Auth2.service;

import niit.jdp.Auth2.exception.UserNotFoundException;
import niit.jdp.Auth2.model.User;

public interface UserService {


    User addUser(User user);

    User login(String userEmail, String password);

    User updateUser(String useremail, User updatedUser)throws UserNotFoundException;

    User getAllDetails(String useremail)throws Exception;
}
