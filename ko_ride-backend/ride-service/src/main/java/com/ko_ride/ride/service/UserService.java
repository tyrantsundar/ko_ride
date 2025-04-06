package com.ko_ride.ride.service;

import com.ko_ride.ride.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    Optional<UserDTO> getUserById(Long userId);
    List<UserDTO> getAllUsers();
}
