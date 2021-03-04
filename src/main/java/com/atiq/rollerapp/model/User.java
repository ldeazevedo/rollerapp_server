package com.atiq.rollerapp.model;

import com.atiq.rollerapp.model.dto.UserDTO;
import com.atiq.rollerapp.security.StringAttributeConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"password"})
public class User {

    @Id
    private String username;

    @Column
    private String name;

    @Column
    @Convert(converter = StringAttributeConverter.class)
    private String password;

    public User() {
    }

    public User(UserDTO userDTO) {
        setName(userDTO.getName());
        setUsername(userDTO.getUsername());
        setPassword(userDTO.getPassword());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("name='" + name + "'")
                .add("password='*****'")
                .toString();
    }
}