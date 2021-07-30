package be.intecbrussel.testy.service;

import be.intecbrussel.testy.data.dto.UserDTO;
import be.intecbrussel.testy.data.entity.UserEntity;
import be.intecbrussel.testy.data.http.HttpExceptionMessage;
import be.intecbrussel.testy.exception.UserException;
import be.intecbrussel.testy.mapper.UserMapper;
import be.intecbrussel.testy.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

// SPRING
@Service

// LOMBOK

public class UserService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Transactional
    public void create(UserDTO request) throws UserException {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserException(HttpExceptionMessage.USER_EMAIL_ALREADY_EXIST.name());
        }

        final var entity = userMapper.toEntity(request);
        final var savedUser = userRepository.save(entity);
        log.info("User is created: " + savedUser);
    }

    @Transactional
    public void update(long id, UserDTO request) throws UserException {
        final var foundEntity = userRepository.findById(id);
        if (foundEntity.isEmpty()) {
            throw new UserException(HttpExceptionMessage.MANAGER_IS_NOT_FOUND.name());
        }

        final var updatedEntity = userMapper.toEntity(request, foundEntity.get());
        final var savedUser = userRepository.save(updatedEntity);
        log.info("User is created: " + savedUser);
    }

    public Set<UserDTO> selectAll(int pageSize, int pageNo) throws UserException {
        final var entities = userRepository.findAll(PageRequest.of(pageNo, pageSize));
        final var responses = new LinkedHashSet<UserDTO>();
        for (UserEntity entity : entities) {
            responses.add(userMapper.toDTO(entity));
        }
        return responses;
    }

    public UserDTO selectByUsername(final String username) throws UserException {
        final var entity = userRepository.findByEmail(username);
        if (entity.isEmpty()) {
            throw new UserException(HttpExceptionMessage.MANAGER_IS_NOT_FOUND.name());
        }

        return userMapper.toDTO(entity.get());
    }

    @Transactional
    public boolean patchSession(final String email, final String session) throws UserException {

        if (Objects.isNull(email) || Objects.isNull(session)) {
            throw new UserException("User email and|or session is (are) required.");
        }

        final var oUser = userRepository.findByEmail(email);

        if (oUser.isEmpty()) {
            throw new UserException("User does NOT exist!");
        }

        final var foundUser = oUser.get();
        if (!foundUser.isActivated()) {
            throw new UserException("User is not activated!");
        }

        if (!foundUser.isAuthenticated()) {
            throw new UserException("User is not authenticated!");
        }

        int noOfRowsEffected = 0;
        if (!foundUser.getSession().equalsIgnoreCase(session)) {
            noOfRowsEffected = userRepository.updateSessionByEmail(email, session);
        }

        return noOfRowsEffected > 0;
    }

    @Transactional
    public boolean activate(final String email, final String activation) throws UserException {

        if (Objects.isNull(email) || Objects.isNull(activation)) {
            throw new UserException("User email and|or activation request is (are) required.");
        }

        final var oStudent = userRepository.findByEmailAndActivation(email, activation);
        if (oStudent.isEmpty()) {
            return false;
        }

        userRepository.updateActivatedById(oStudent.get().getId(), true);
        return true;
    }

    @Transactional
    public boolean deActivate(long id) throws UserException {

        if (Objects.isNull(id) || id < 1) {
            throw new UserException("User activation request is required.");
        }

        final var userExists = userRepository.existsById(id);
        if (userExists) {
            return false;
        }

        userRepository.updateActivatedById(id, true);
        return true;
    }

    @Transactional
    public boolean authenticate(final String email, final String password) throws UserException {

        if (Objects.isNull(email) || Objects.isNull(password)) {
            throw new UserException("User activation request is required.");
        }

        final var oStudent = userRepository.findByEmailAndPassword(email, password);
        if (oStudent.isEmpty()) {
            return false;
        }

        userRepository.updateAuthenticatedById(oStudent.get().getId(), true);
        return true;
    }

    @Transactional
    public boolean deAuthenticate(long id) throws UserException {

        if (Objects.isNull(id) || id < 1) {
            throw new UserException("User activation request is required.");
        }

        final var userExists = userRepository.existsById(id);
        if (userExists) {
            return false;
        }

        userRepository.updateAuthenticatedById(id, true);
        return true;
    }
}
