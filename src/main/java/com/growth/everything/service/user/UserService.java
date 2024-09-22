package com.growth.everything.service.user;

import com.growth.everything.dto.user.UserLoginDTO;
import com.growth.everything.dto.user.UserSessionDTO;
import com.growth.everything.dto.user.UserSignupDTO;

public interface UserService {
    void signup(UserSignupDTO userSignupDTO);
    UserSessionDTO login(UserLoginDTO userLoginDTO);

}
