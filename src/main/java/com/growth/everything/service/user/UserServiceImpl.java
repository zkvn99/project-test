package com.growth.everything.service.user;

import com.growth.everything.dto.user.UserDTO;
import com.growth.everything.entity.user.UserEntity;
import com.growth.everything.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void signup(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.fromUserDTO(userDTO);
        userRepository.save(userEntity);
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        Optional<UserEntity> optionalUser = userRepository.getByEmail(userDTO.getUserEmail());
        if(optionalUser.isPresent()) {
            UserEntity userEntity = optionalUser.get();
            if(userDTO.getUserPassword().equals(userEntity.getUserPassword())) {
                UserDTO user = UserDTO.fromUserEntity(userEntity);
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
