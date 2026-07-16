package com.saonnet.ludo.userprofile.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

    @NotEmpty
    @NotNull
    String username;

    @NotEmpty
    @NotNull
    String email;

    @NotEmpty
    @NotNull
    String password;
}
