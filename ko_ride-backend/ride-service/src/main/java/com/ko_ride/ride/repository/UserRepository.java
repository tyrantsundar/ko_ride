package com.ko_ride.ride.repository;

import com.ko_ride.ride.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String mail);
    Optional<User> findByMobileNumber(String mobileNumber);
}
