package org.example.dto;

import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link org.example.model.User}
 */
public record UserRequestDto(@Pattern(regexp = "^[A-Za-z]{3,29}$") String firstName,
                             @Pattern(regexp = "^[A-Za-z]{3,29}$") String lastName,
                             String userName,
                             @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8}$") String password,
                             LocalDate registerDate,
                             LocalDate birthDate) implements Serializable {
}