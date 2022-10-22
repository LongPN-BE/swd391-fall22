package com.groupswd391.fall22.User.DTO;

import com.groupswd391.fall22.Major.Major;
import com.groupswd391.fall22.Role.Role;
import com.groupswd391.fall22.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {
    private int id;
    private Role role;
    private Major major;
    private String fullname;
    private String email;
    private String phone;
    private Date dob;
    private Integer legit;
    private String img;

    public static UserDtoResponse buildFromUser(User user) {
        return new UserDtoResponse(
                user.getId(),
                user.getRole(),
                user.getMajor(),
                user.getFullname(),
                user.getEmail(),
                user.getPhone(),
                user.getDob(),
                user.getLegit(),
                user.getImg()
        );
    }
}
