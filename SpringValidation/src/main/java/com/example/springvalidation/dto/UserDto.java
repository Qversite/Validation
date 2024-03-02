package com.example.springvalidation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDto {
    private Long id;

    @NotBlank(message = "Поле не может быть пустым!")
    @Size(max = 10, min = 2, message = "Допустимая длина от 2 до 10 символов")
    @Pattern(regexp = "[A-z]", message = "Может содержать только символы от A до Z")
    private String username;

    @NotBlank
    @Size(max = 10, min = 2)
    private String password;

    @NotBlank
    @Size(max = 10, min = 2)
    private String name;
}
