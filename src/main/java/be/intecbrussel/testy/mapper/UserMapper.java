package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.UserDTO;
import be.intecbrussel.testy.data.entity.UserEntity;

public interface UserMapper {

    UserDTO toDTO(UserEntity source);

    UserEntity toEntity(UserDTO source);

    UserEntity toEntity(UserDTO source, UserEntity destination);

}
