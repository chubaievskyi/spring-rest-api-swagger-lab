package com.chubaievskyi.mapper;

import com.chubaievskyi.dto.UserDto;
import com.chubaievskyi.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto entityToDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getIpn()
        );
    }

    public UserEntity dtoToEntity(UserDto userDto) {
        return new UserEntity(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getIpn()
        );
    }

}
