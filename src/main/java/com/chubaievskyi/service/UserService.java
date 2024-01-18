package com.chubaievskyi.service;

import com.chubaievskyi.dto.UserDto;
import com.chubaievskyi.entity.UserEntity;
import com.chubaievskyi.exception.ResourceNotFoundException;
import com.chubaievskyi.mapper.IUserMapper;
import com.chubaievskyi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = IUserMapper.MAPPER.dtoToEntity(userDto);
        UserEntity savedUser = userRepository.save(userEntity);
        return IUserMapper.MAPPER.entityToDto(savedUser);
    }

    public UserDto updateUser(UserDto userDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userDto.getId());
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = IUserMapper.MAPPER.dtoToEntity(userDto);
            userEntity.setId(optionalUserEntity.get().getId());
            UserEntity updatedUser = userRepository.save(userEntity);
            return IUserMapper.MAPPER.entityToDto(updatedUser);
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
            return IUserMapper.MAPPER.entityToDto(optionalUserEntity.get());
        } else {
            throw new ResourceNotFoundException("User not found with ID: " + id);
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    public List<UserDto> findAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return IUserMapper.MAPPER.entityListToDtoList(userEntities);
    }
}