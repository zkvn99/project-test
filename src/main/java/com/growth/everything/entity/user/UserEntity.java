package com.growth.everything.entity.user;

import jakarta.persistence.*;
import lombok.*;
import com.growth.everything.dto.user.UserDTO;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@SequenceGenerator(sequenceName = "user_seq", name = "user_seq_gen", initialValue = 1, allocationSize = 1)
public class UserEntity {

    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true) // unique 제약조건 추가
    private String userEmail;

    @Column
    private String userPassword;

    @Column
    private String userName;

    @Column(unique = true)
    private String userNickname;

    @Column
    private String userPhone;

    @Column
    private String userAddress;

    public static UserEntity fromUserDTO(UserDTO userDTO) {
        return new UserEntity(
                userDTO.getId(),
                userDTO.getUserEmail(),
                userDTO.getUserPassword(),
                userDTO.getUserName(),
                userDTO.getUserNickname(),
                userDTO.getUserPhone(),
                userDTO.getUserAddress()
        );
    }
}
