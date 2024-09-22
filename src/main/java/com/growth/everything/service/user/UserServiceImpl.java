package com.growth.everything.service.user;

import com.growth.everything.dto.user.UserLoginDTO;
import com.growth.everything.dto.user.UserSessionDTO;
import com.growth.everything.dto.user.UserSignupDTO;
import com.growth.everything.entity.user.UserEntity;
import com.growth.everything.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void signup(UserSignupDTO userSignupDTO) {
        UserEntity userEntity = UserEntity.fromUserDTO(userSignupDTO);
        System.out.println(userEntity);
        userRepository.save(userEntity);
    }

    @Override
    public UserSessionDTO login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> optionalUser = userRepository.getByUserEmail(userLoginDTO.getUserEmail());
        if(optionalUser.isPresent()) {
            UserEntity userEntity = optionalUser.get();
            if(userLoginDTO.getUserPassword().equals(userEntity.getUserPassword())) {
                UserSessionDTO user = UserSessionDTO.fromUserEntity(userEntity);
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
