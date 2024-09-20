package com.growth.everything.repository.user;

import com.growth.everything.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    Optional<UserEntity> getByEmail(String email);

}
