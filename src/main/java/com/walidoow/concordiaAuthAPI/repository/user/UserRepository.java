package com.walidoow.concordiaAuthAPI.repository.user;

import com.walidoow.concordiaAuthAPI.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(UUID id);

    Optional<User> findUserByNetname(String netname);

    Optional<User> findUserByPhoneNumber(String phoneNumber);

    void deleteUserById(UUID id);

}
