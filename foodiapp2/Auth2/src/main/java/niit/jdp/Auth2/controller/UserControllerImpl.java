package niit.jdp.Auth2.controller;


import niit.jdp.Auth2.exception.UserNotFoundException;
import niit.jdp.Auth2.model.User;
import niit.jdp.Auth2.security.SecurityTokenGenerator;
import niit.jdp.Auth2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user/v1")
public class UserControllerImpl {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;
    //http://localhost:8089/user/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    //http://localhost:8082/user/v1/login
    // @CrossOrigin(origins = "http://localhost:52110")
    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user) {
        User result = userService.login(user.getUseremail(), user.getPassword());
        if (result != null) {
            Map<String, String> key = securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(key, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.NOT_FOUND);
        }
    }

    // http://localhost:8089/user/v1/
    @PutMapping("/{useremail}")
    public User updateUser(@PathVariable String useremail, @RequestBody User updatedUser) throws UserNotFoundException {
//        updatedUser.setUseremail(useremail); // Ensure useremail is not changed
        return userService.updateUser(useremail, updatedUser);
    }
    @GetMapping("/get/{useremail}")
    public ResponseEntity<?> getAll(@PathVariable String useremail) throws Exception {
        return  new ResponseEntity<>(userService.getAllDetails(useremail),HttpStatus.OK);
    }
}
