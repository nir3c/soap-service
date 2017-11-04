package com.repository;

import generated.User;

import java.util.Optional;

/**
 * Created by Nir on 11/4/2017.
 */
public interface IUserRepository {

    Optional<User> findUser(String username, String password);
    boolean updateUserInfo(String oldUsername, String oldPassword, String newUsername, String newPassword);
}
