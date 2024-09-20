package com.growth.everything.service.user;

import com.growth.everything.dto.user.UserDTO;

public interface UserService {
    void signup(UserDTO userDTO);
    UserDTO login(UserDTO userDTO);

}
