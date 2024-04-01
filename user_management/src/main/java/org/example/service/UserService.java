package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserRequestDto;
import org.example.exception.UserAllReadyException;
import org.example.exception.UserNotFoundException;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void register(User user) {
        Optional<User> byUserName = userRepository.findByUserName(user.getUserName());
        if (byUserName.isPresent())
            throw new UserAllReadyException("this user already exist");
        userRepository.save(user);
    }

    public User update(UserRequestDto user, String username) {
        Optional<User> optionalUser = userRepository.findByUserName(username);
        User user1 = optionalUser.orElseThrow(() -> new UserNotFoundException("this user not found"));
        setUpdateFieldsForUser(user1, user);
        return userRepository.save(user1);
    }

    private void setUpdateFieldsForUser(User oldUser, UserRequestDto newUser) {
        Optional.ofNullable(newUser.firstName()).ifPresent(oldUser::setFirstName);
        Optional.ofNullable(newUser.lastName()).ifPresent(oldUser::setLastName);
        Optional.ofNullable(newUser.userName()).ifPresent(oldUser::setUserName);
        Optional.ofNullable(newUser.password()).ifPresent(oldUser::setPassword);
        Optional.ofNullable(newUser.birthDate()).ifPresent(oldUser::setBirthDate);
    }
}
