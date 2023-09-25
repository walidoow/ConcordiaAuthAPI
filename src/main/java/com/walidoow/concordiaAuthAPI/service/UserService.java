package com.walidoow.concordiaAuthAPI.service;

import com.walidoow.concordiaAuthAPI.entity.user.User;

public interface UserService {

    User createUser(User user);

    User getUserById(String id);

    User getUserByNetname(String netname);

    void deleteUserById(String id);
}
