package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.UserRequestDto;
import org.example.dto.UserResponseDto;
import org.example.mapStruct.MapStruct;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponseDto register(@Valid @RequestBody UserRequestDto userRequestDto) {
        User user = MapStruct.INSTANCE.UserRequestDtoToModel(userRequestDto);
        userService.register(user);
        return MapStruct.INSTANCE.modelToUserResponseDto(user);
    }

    @PutMapping
    public UserResponseDto update(@Valid @RequestBody UserRequestDto userRequestDto,@RequestParam String username) {
        User updatedUser = userService.update(userRequestDto, username);
        return MapStruct.INSTANCE.modelToUserResponseDto(updatedUser);
    }
}
