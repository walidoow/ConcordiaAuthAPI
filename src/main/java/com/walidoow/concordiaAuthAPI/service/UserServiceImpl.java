package com.walidoow.concordiaAuthAPI.service;

import com.walidoow.concordiaAuthAPI.entity.user.User;
import com.walidoow.concordiaAuthAPI.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        var newUser = User.builder()
                .withCreatedAt(Timestamp.from(Instant.now()))
                .withUpdatedAt(Timestamp.from(Instant.now()))
                .withNetname(user.getNetname())
                .withPhoneNumber(user.getPhoneNumber())
                .build();
        return userRepository.save(newUser);
    }

    @Override
    public User getUserById(String id) {
        Optional<User> user = userRepository.findUserById(UUID.fromString(id));
        if (user.isEmpty())
            throw new RuntimeException("User with id " + id + " was not found");
        return user.get();
    }

    @Override
    public User getUserByNetname(String netname) {
        Optional<User> user = userRepository.findUserByNetname(netname);
        if (user.isEmpty())
            throw new RuntimeException("User with netname " + netname + " was not found");
        return user.get();
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteUserById(UUID.fromString(id));
    }

}
