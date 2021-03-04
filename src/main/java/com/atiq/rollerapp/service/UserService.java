package com.atiq.rollerapp.service;

import com.atiq.rollerapp.model.User;
import com.atiq.rollerapp.model.dto.UserDTO;
import com.atiq.rollerapp.repository.UserRepository;
import com.atiq.rollerapp.response.RegisterUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository streetRepository) {
        this.userRepository = streetRepository;
    }

    public User getUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password).orElse(null);
        log.info("User found: {}", user);
        return user;
    }

    public User getUser(UserDTO userDTO) {
        return getUser(userDTO.getUsername(), userDTO.getPassword());
    }

    public RegisterUserResponse validateUserRequest(UserDTO userDTO) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        if (userDTO == null) {
            registerUserResponse.addError("Request can not be null");
            return registerUserResponse;
        }
        if (userDTO.getName() == null || userDTO.getName().isEmpty())
            registerUserResponse.addError("Name field can not be empty");
        if (userDTO.getUsername() == null || userDTO.getUsername().isEmpty())
            registerUserResponse.addError("Username field can not be empty");
        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty())
            registerUserResponse.addError("Password field can not be empty");
        return registerUserResponse;
    }

    public User saveUser(UserDTO userDTO) {
        return userRepository.save(new User(userDTO));
    }
}