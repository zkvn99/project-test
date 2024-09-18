package com.growth.everything.dto.user;

import com.growth.everything.entity.user.UserEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userNickname;
    private String userPhone;
    private String userAddress;

    public static UserDto toUserDto(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUserEmail(userEntity.getUserEmail());
        userDto.setUserPassword(userEntity.getUserPassword());
        userDto.setUserName(userEntity.getUserName());
        userDto.setUserNickname(userEntity.getUserNickname());
        userDto.setUserPhone(userEntity.getUserPhone());
        userDto.setUserAddress(userEntity.getUserAddress());
        return userDto;
    }
}
