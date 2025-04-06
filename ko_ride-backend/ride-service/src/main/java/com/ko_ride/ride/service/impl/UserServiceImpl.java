package com.ko_ride.ride.service.impl;

import com.ko_ride.ride.dto.UserDTO;
import com.ko_ride.ride.entity.User;
import com.ko_ride.ride.mapper.UserMapper;
import com.ko_ride.ride.repository.UserRepository;
import com.ko_ride.ride.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public Optional<UserDTO> getUserById(Long userId) {
        return userRepository.findById(userId).map(userMapper::toDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}


