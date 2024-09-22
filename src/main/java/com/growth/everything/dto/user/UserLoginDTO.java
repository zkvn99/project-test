package com.growth.everything.dto.user;

import com.growth.everything.entity.user.UserEntity;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserLoginDTO {
    private String userEmail;
    private String userPassword;

    public UserLoginDTO(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
