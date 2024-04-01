package org.example.mapStruct;

import org.example.dto.UserRequestDto;
import org.example.dto.UserResponseDto;
import org.example.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStruct {

    MapStruct INSTANCE = Mappers.getMapper(MapStruct.class);

    User UserResponseDtoToModel(UserResponseDto userResponseDto);
    User UserRequestDtoToModel(UserRequestDto userRequestDto);
    UserResponseDto modelToUserResponseDto(User user);
}
