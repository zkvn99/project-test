package com.growth.everything.service.user;

import com.growth.everything.dto.user.UserDto;
import com.growth.everything.entity.user.UserEntity;
import com.growth.everything.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void signup(UserDto userDto) {
        UserEntity userEntity = UserEntity.toUserEntity(userDto);
        userRepository.save(userEntity);
    }
}
