package com.service;

import com.repository.IUserRepository;
import com.generated.User;
import com.generated.UserAuthentication;
import com.generated.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Nir on 11/4/2017.
 */
@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(UserAuthentication userAuthentication) {
        return userRepository.findUser(userAuthentication.getUsername(), userAuthentication.getPassword());
    }

    public boolean updateUserInfo(UserAuthentication userAuthentication, UserUpdate updates) {
        return userRepository.updateUserInfo(userAuthentication.getUsername(), userAuthentication.getPassword(),
                updates.getUsername(), updates.getPassword());
    }
}
