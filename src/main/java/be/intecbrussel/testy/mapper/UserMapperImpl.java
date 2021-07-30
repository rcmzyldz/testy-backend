package be.intecbrussel.testy.mapper;

import be.intecbrussel.testy.data.dto.UserDTO;
import be.intecbrussel.testy.data.entity.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(UserEntity source) {
        if ( source == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( source.getId() );
        if ( source.getFirstName() != null ) {
            userDTO.setFirstName( source.getFirstName() );
        }
        if ( source.getLastName() != null ) {
            userDTO.setLastName( source.getLastName() );
        }
        if ( source.getEmail() != null ) {
            userDTO.setEmail( source.getEmail() );
        }
        if ( source.getPhone() != null ) {
            userDTO.setPhone( source.getPhone() );
        }
        if ( source.getPassword() != null ) {
            userDTO.setPassword( source.getPassword() );
        }
        if ( source.getRoles() != null ) {
            userDTO.setRoles( source.getRoles() );
        }
        if ( source.getSession() != null ) {
            userDTO.setSession( source.getSession() );
        }
        if ( source.getActivation() != null ) {
            userDTO.setActivation( source.getActivation() );
        }
        userDTO.setActivated( source.isActivated() );
        userDTO.setAuthenticated( source.isAuthenticated() );
        if ( source.getProfile() != null ) {
            userDTO.setProfile( source.getProfile() );
        }

        return userDTO;
    }

    @Override
    public UserEntity toEntity(UserDTO source) {
        if ( source == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( source.getId() );
        if ( source.getFirstName() != null ) {
            userEntity.setFirstName( source.getFirstName() );
        }
        if ( source.getLastName() != null ) {
            userEntity.setLastName( source.getLastName() );
        }
        if ( source.getEmail() != null ) {
            userEntity.setEmail( source.getEmail() );
        }
        if ( source.getPhone() != null ) {
            userEntity.setPhone( source.getPhone() );
        }
        if ( source.getPassword() != null ) {
            userEntity.setPassword( source.getPassword() );
        }
        if ( source.getRoles() != null ) {
            userEntity.setRoles( source.getRoles() );
        }
        if ( source.getSession() != null ) {
            userEntity.setSession( source.getSession() );
        }
        if ( source.getActivation() != null ) {
            userEntity.setActivation( source.getActivation() );
        }
        userEntity.setActivated( source.isActivated() );
        userEntity.setAuthenticated( source.isAuthenticated() );
        if ( source.getProfile() != null ) {
            userEntity.setProfile( source.getProfile() );
        }

        return userEntity;
    }

    @Override
    public UserEntity toEntity(UserDTO source, UserEntity destination) {
        if ( source == null ) {
            return null;
        }

        destination.setId( source.getId() );
        if ( source.getFirstName() != null ) {
            destination.setFirstName( source.getFirstName() );
        }
        if ( source.getLastName() != null ) {
            destination.setLastName( source.getLastName() );
        }
        if ( source.getEmail() != null ) {
            destination.setEmail( source.getEmail() );
        }
        if ( source.getPhone() != null ) {
            destination.setPhone( source.getPhone() );
        }
        if ( source.getPassword() != null ) {
            destination.setPassword( source.getPassword() );
        }
        if ( source.getRoles() != null ) {
            destination.setRoles( source.getRoles() );
        }
        if ( source.getSession() != null ) {
            destination.setSession( source.getSession() );
        }
        if ( source.getActivation() != null ) {
            destination.setActivation( source.getActivation() );
        }
        destination.setActivated( source.isActivated() );
        destination.setAuthenticated( source.isAuthenticated() );
        if ( source.getProfile() != null ) {
            destination.setProfile( source.getProfile() );
        }

        return destination;
    }
}
