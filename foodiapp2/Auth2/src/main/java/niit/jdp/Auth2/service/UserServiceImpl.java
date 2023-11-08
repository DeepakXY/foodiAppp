package niit.jdp.Auth2.service;

import niit.jdp.Auth2.exception.UserNotFoundException;
import niit.jdp.Auth2.model.User;

import niit.jdp.Auth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(String userEmail, String password) {
        if (userRepository.findById(userEmail).isPresent()) {
            User user = userRepository.findById(userEmail).get();
            if (user.getPassword().equals(password)) {
                user.setPassword("");
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    @Override
    public User updateUser(String useremail, User updatedUser)throws UserNotFoundException {
        User existingUser = userRepository.findById(useremail).orElse(null);
        if (existingUser != null) {
            // Update the fields with the new values
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setFirstname(updatedUser.getFirstname());
            existingUser.setLastname(updatedUser.getLastname());
            existingUser.setGender(updatedUser.getGender());
            existingUser.setUserMobileNumber(updatedUser.getUserMobileNumber());
            existingUser.setDate(updatedUser.getDate());

            return userRepository.save(existingUser);
        } else {
            // Handle user not found
            throw new UserNotFoundException();
        }
    }

    @Override
public User getAllDetails(String useremail)throws Exception{
       return userRepository.findById(useremail).get();
}
}
