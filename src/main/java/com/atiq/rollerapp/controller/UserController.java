package com.atiq.rollerapp.controller;

import com.atiq.rollerapp.model.User;
import com.atiq.rollerapp.model.dto.UserDTO;
import com.atiq.rollerapp.response.RegisterUserResponse;
import com.atiq.rollerapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("rest/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> tryLogin(@RequestBody UserDTO userDTO) {
        log.info("Request: {}", userDTO);

        User user = userService.getUser(userDTO);

        Map<String, Object> response = new HashMap<>();
        response.put("result", user == null ? "invalid_data" : "ok");
        if (user != null)
            response.put("user", user);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody UserDTO userDTO) {
        RegisterUserResponse registerUserResponse = userService.validateUserRequest(userDTO);
        if (!registerUserResponse.containsErrors()) {
            User savedUser = userService.saveUser(userDTO);
            registerUserResponse.setUser(savedUser);
            return ResponseEntity.ok(registerUserResponse);
        } else {
            registerUserResponse.setMessage("Errors were found in the request. Please take a look.");
            registerUserResponse.setStatusCode(400);
            return ResponseEntity.badRequest().body(registerUserResponse);
        }
    }
}