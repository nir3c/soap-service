package com.endpoint;

import com.service.IUserService;
import com.service.UserService;
import com.generated.*;
import com.util.UserEndPointUtils;
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

    private final IUserService userService;
    private final static String NAMESPACE_URI = "http://niro.io/user";

    @Autowired
    public UserEndpoint(IUserService userService) {
        this.userService = userService;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUserInfo(@RequestPayload UpdateUserRequest req){
        boolean success = userService.updateUserInfo(req.getUserAuthentication(), req.getUserUpdate());
        return UserEndPointUtils.createUpdateUserResponse(req.getUserUpdate().getUsername(),
                req.getUserUpdate().getPassword(), success);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserInfoRequest")
    @ResponsePayload
    public GetUserInfoResponse getUserInfo(@RequestPayload GetUserInfoRequest req){
        Optional<User> user = userService.findUser(req.getUserAuthentication());
        return UserEndPointUtils.createGetUserInfoResponse(user);
    }
}
