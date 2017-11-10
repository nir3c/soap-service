package com.service;

import com.generated.User;
import com.generated.UserAuthentication;
import com.generated.UserUpdate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Nir.
 */
@Service
public interface IUserService {
    Optional<User> findUser(UserAuthentication userAuthentication);
    boolean updateUserInfo(UserAuthentication userAuthentication, UserUpdate updates);
}
