package com.chubaievskyi.service;

import com.chubaievskyi.dto.UserDto;
import com.chubaievskyi.entity.UserEntity;
import com.chubaievskyi.exception.ResourceNotFoundException;
import com.chubaievskyi.mapper.UserMapper;
import com.chubaievskyi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.MAPPER.dtoToEntity(userDto);
        UserEntity savedUser = userRepository.save(userEntity);
        return UserMapper.MAPPER.entityToDto(savedUser);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = UserMapper.MAPPER.dtoToEntity(userDto);
            userEntity.setId(optionalUserEntity.get().getId());
            UserEntity updatedUser = userRepository.save(userEntity);
            return UserMapper.MAPPER.entityToDto(updatedUser);
        } else {
            throw new ResourceNotFoundException("User not found with ID: " + userDto.getId());
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }

    public UserDto findUserById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            return UserMapper.MAPPER.entityToDto(optionalUserEntity.get());
        } else {
            throw new ResourceNotFoundException("User not found with ID: " + id);
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }


    public Page<UserDto> findAllUsers(Pageable pageable) {
        Page<UserEntity> userEntityPage = userRepository.findAll(pageable);
        return userEntityPage.map(UserMapper.MAPPER::entityToDto);
    }
}