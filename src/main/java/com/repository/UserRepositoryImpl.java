package com.repository;

import com.util.Utils;
import com.generated.User;
import com.generated.UserType;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Nir on 11/4/2017.
 */
@Repository
public class UserRepositoryImpl implements IUserRepository {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initData() {
        User nirUser = new User();
        nirUser.setUsername("nir");
        nirUser.setPassword("password");
        nirUser.setFirstName("nir");
        nirUser.setLastName("nir");
        nirUser.setId(1);
        UserType nirUserType = new UserType();
        nirUserType.setId(101);
        nirUserType.setName("Super User Type");
        nirUser.setType(nirUserType);
        users.put("nir",nirUser);
    }

    @Override
    public Optional<User> findUser(String username, String password) {
        Optional<User> user = Optional.ofNullable(users.get(username));
        return user.isPresent() && user.get().getPassword().equals(password) ?
                user : Optional.empty();
    }

    private Optional<User> findUser(String username) {
        return Optional.ofNullable(users.get(username));
    }

    private Optional<User> removeUser(String username) {
        return Optional.ofNullable(users.remove(username));
    }

    private User addUser(String username, User user) {
        return users.put(username, user);
    }


    @Override
    public boolean updateUserInfo(String oldUsername, String oldPassword,String newUsername, String newPassword) {
        return updateUserInfo(findUser(oldUsername, oldPassword), newUsername, newPassword);
    }

    private boolean updateUserInfo(Optional<User> changeUser, String newUsername, String newPassword) {
        if(!changeUser.isPresent() ||
                !isNewParametersValid(newUsername, newPassword) ||
                (!changeUser.get().getUsername().equals(newUsername) &&
                        findUser(newUsername).isPresent())
                )
            return false;
        User user = changeUser.get();
        String oldUsername = user.getUsername();
        if(!Utils.isEmpty(newUsername, true))
            user.setUsername(newUsername);
        if(!Utils.isEmpty(newPassword, true))
            user.setPassword(newPassword);
        return addUser(oldUsername, user) != null;
    }

    private boolean isNewParametersValid(String username, String password) {
        return !(Utils.isEmpty(username, true) && Utils.isEmpty(password, true));
    }
}
