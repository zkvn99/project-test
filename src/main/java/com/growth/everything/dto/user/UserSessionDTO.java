package com.growth.everything.dto.user;

import com.growth.everything.entity.user.UserEntity;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserSessionDTO {
    private String userEmail;
    private String userName;
    private String userNickname;
    private String userPhone;
    private String userAddress;

    public UserSessionDTO(String userName, String userNickname, String userPhone, String userAddress, String userEmail) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userNickname = userNickname;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }

    public static UserSessionDTO fromUserEntity(UserEntity userEntity) {
        return new UserSessionDTO(
                userEntity.getUserEmail(),
                userEntity.getUserName(),
                userEntity.getUserNickname(),
                userEntity.getUserPhone(),
                userEntity.getUserAddress()
        );
    }
}
