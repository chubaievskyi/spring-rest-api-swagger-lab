package com.chubaievskyi.controller;

import com.chubaievskyi.dto.UserDto;
import com.chubaievskyi.entity.UserEntity;
import com.chubaievskyi.mapper.UserMapper;
import com.chubaievskyi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto> getUsers() {
        Iterable<UserEntity> users = userService.findAllUsers();

        List<UserDto> userDtoList = new ArrayList<>();
        users.forEach(user -> userDtoList.add(userMapper.entityToDto(user)));

        return userDtoList;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        UserEntity user = userService.findUserById(id);
        return userMapper.entityToDto(user);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        UserEntity user = userMapper.dtoToEntity(userDto);
        return userMapper.entityToDto(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserEntity user = userMapper.dtoToEntity(userDto);
        user.setId(id);
        return userMapper.entityToDto(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
