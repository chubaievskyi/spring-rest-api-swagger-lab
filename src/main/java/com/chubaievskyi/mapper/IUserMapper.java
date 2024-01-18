package com.chubaievskyi.mapper;

import com.chubaievskyi.dto.UserDto;
import com.chubaievskyi.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    IUserMapper MAPPER = Mappers.getMapper(IUserMapper.class);

    UserDto entityToDto(UserEntity userEntity);
    UserEntity dtoToEntity(UserDto userDto);
    List<UserDto> entityListToDtoList(List<UserEntity> userEntities);
}