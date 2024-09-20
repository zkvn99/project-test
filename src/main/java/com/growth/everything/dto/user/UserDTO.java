package com.growth.everything.dto.user;

import com.growth.everything.entity.user.UserEntity;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userNickname;
    private String userPhone;
    private String userAddress;

    public static UserDTO fromUserEntity(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getUserEmail(),
                userEntity.getUserPassword(),
                userEntity.getUserName(),
                userEntity.getUserNickname(),
                userEntity.getUserPhone(),
                userEntity.getUserAddress()
        );
    }
}
