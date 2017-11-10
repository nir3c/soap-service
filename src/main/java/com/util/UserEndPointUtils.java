package com.util;

import com.generated.GetUserInfoResponse;
import com.generated.UpdateUserResponse;
import com.generated.User;
import com.generated.UserAuthentication;

import java.util.Optional;

/**
 * Created by Nir on 11/10/2017.
 */
public class UserEndPointUtils {

    public static UpdateUserResponse createUpdateUserResponse(String newUsername, String newPassword, boolean success) {
        UpdateUserResponse res = new UpdateUserResponse();
        res.setSuccess(success);
        res.setSuccessDescription(success ? "Success" : "Update Failed");
        if(success){
            UserAuthentication userAuthentication = new UserAuthentication();
            userAuthentication.setUsername(newUsername);
            userAuthentication.setPassword(newPassword);
            res.setUserAuthentication(userAuthentication);
        }
        return res;
    }

    public static GetUserInfoResponse createGetUserInfoResponse(Optional<User> user) {
        GetUserInfoResponse res = new GetUserInfoResponse();
        res.setSuccess(user.isPresent());
        String description = user.isPresent() ? "Success" : "User not found";
        res.setSuccessDescription(description);
        res.setUser(user.orElse(null));
        return res;
    }

}
