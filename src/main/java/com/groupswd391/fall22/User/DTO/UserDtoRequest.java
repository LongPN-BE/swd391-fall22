package com.groupswd391.fall22.User.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String fullname;
    @NotNull
    private String major;
    @NotNull
    private String phone;
    @NotNull
    private String img;

    private boolean status ;
}
