package com.atiq.rollerapp.response;

import com.atiq.rollerapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RegisterUserResponse {

    private int statusCode = 200;
    private String message = "Success";
    private User user;
    private List<String> errors;

    public RegisterUserResponse() {
        errors = new ArrayList<>();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String error) {
        errors.add(error);
    }

    public boolean containsErrors() {
        return !errors.isEmpty();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RegisterUserResponse.class.getSimpleName() + "[", "]")
                .add("statusCode=" + statusCode)
                .add("message='" + message + "'")
                .add("user=" + user)
                .add("errors=" + errors)
                .toString();
    }
}