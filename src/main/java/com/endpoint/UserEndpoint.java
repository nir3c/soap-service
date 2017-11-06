package com.endpoint;

import com.service.UserService;
import com.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

/**
 * Created by Nir on 11/4/2017.
 */
@Endpoint
public class UserEndpoint {

    private final UserService userService;
    private final static String NAMESPACE_URI = "http://niro.io/user";

    @Autowired
    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUserInfo(@RequestPayload UpdateUserRequest req){
        boolean success = userService.updateUserInfo(req.getUserAuthentication(), req.getUserUpdate());
        UpdateUserResponse res = createUpdateUserResponse(req.getUserUpdate().getUsername(),
                req.getUserUpdate().getPassword(), success);
        return res;
    }

    private UpdateUserResponse createUpdateUserResponse(String newUsername, String newPassword, boolean success) {
        UpdateUserResponse res = new UpdateUserResponse();
        res.setSuccess(success);
        res.setSuccessDescription(success ? "Success" : "Update Failed");
        UserAuthentication userAuthentication = null;
        if(success){
            userAuthentication = new UserAuthentication();
            userAuthentication.setUsername(newUsername);
            userAuthentication.setPassword(newPassword);
            res.setUserAuthentication(userAuthentication);
        }
        return res;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserInfoRequest")
    @ResponsePayload
    public GetUserInfoResponse getUserInfo(@RequestPayload GetUserInfoRequest req){
        Optional<User> user = userService.findUser(req.getUserAuthentication());
        GetUserInfoResponse res = createGetUserInfoResponse(user);
        return res;
    }

    private GetUserInfoResponse createGetUserInfoResponse(Optional<User> user) {
        GetUserInfoResponse res = new GetUserInfoResponse();
        res.setSuccess(user.isPresent());
        String description = user.isPresent() ? "Success" : "User not found";
        res.setSuccessDescription(description);
        res.setUser(user.orElse(null));
        return res;
    }
}
