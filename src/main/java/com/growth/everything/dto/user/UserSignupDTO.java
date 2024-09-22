package com.growth.everything.dto.user;

import com.growth.everything.entity.user.UserEntity;
import lombok.*;

@Getter
@ToString
public class UserSignupDTO {
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userNickname;
    private String userPhone;
    private String userAddress;

    public UserSignupDTO(String userName, String userNickname, String userPhone, String userAddress, String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userNickname = userNickname;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }
}
