package com.ko_ride.ride.mapper;

import com.ko_ride.ride.dto.UserDTO;
import com.ko_ride.ride.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    UserDTO toDTO(User user);
//    User toEntity(UserDTO userDTO);
//
//    @Mapping(source = "", target = "userId")
    User toEntity(UserDTO userDTO);

//    @Mapping(source = "userId", target = "id")
    UserDTO toDTO(User user);
}

