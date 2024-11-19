package com.example.GroupProject_4.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "firstName can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "firstName must contain only latin letters and no spaces")
    @Size(min = 2,max = 32, message = "firstName size must be between 2-32 characters")
    @Schema(description = "firstName of the user", example = "John Doe", minLength = 2, maxLength = 32)
    private String firstName;

    @NotBlank(message = "lastName can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "lastName must contain only latin letters and no spaces")
    @Size(min = 2,max = 64, message = "lastName size must be between 2-64 characters")
    @Schema(description = "lastName of the user", example = "Doe")
    private String lastName;

    @NotBlank(message = "userName can not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "userName must contain only latin letters or numbers, no spaces")
    @Size(min = 2,max = 64, message = "userName size must be between 2-64 characters")
    @Schema(description = "userName of the user", example = "JD123")
    private String userName;

    @NotNull(message = "birthDate can not be null")
    @Past(message = "birthDate can not be in future")
    private LocalDate birthDate;


}
