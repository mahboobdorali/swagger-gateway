package org.example.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link org.example.model.User}
 */
public record UserResponseDto(Long id,
                              String firstName,
                              String lastName,
                              String userName,
                              LocalDate registerDate,
                              LocalDate birthDate) implements Serializable {
}