package be.intecbrussel.testy.service;

import be.intecbrussel.testy.data.dto.UserDTO;
import be.intecbrussel.testy.data.entity.UserEntity;
import be.intecbrussel.testy.data.http.HttpExceptionMessage;
import be.intecbrussel.testy.service.exception.ResourceNotFoundException;
import be.intecbrussel.testy.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class UserService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void create(UserDTO request) throws ResourceNotFoundException {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceNotFoundException(HttpExceptionMessage.USER_EMAIL_ALREADY_EXIST.name());
        }

        final var savedUser = userRepository.save(request.toEntity());
        log.info("User is created: " + savedUser);
    }

    @Transactional
    public void update(Long id, UserDTO request) throws ResourceNotFoundException {
        final var foundEntity = userRepository.findById(id);
        if (foundEntity.isEmpty()) {
            throw new ResourceNotFoundException("User not found..!");
        }

        request.setId(id);
        final var savedUser = userRepository.save(request.toEntity());
        log.info("User is created: " + savedUser);
    }

    public Set<UserDTO> selectAll(int pageSize, int pageNo) throws ResourceNotFoundException {
        final var entities = userRepository.findAll(PageRequest.of(pageNo, pageSize));
        final var responses = new LinkedHashSet<UserDTO>();
        for (UserEntity entity : entities) {
            responses.add(entity.toDTO());
        }
        return responses;
    }

    public UserDTO selectByUsername(final String username) throws ResourceNotFoundException {
        final var entity = userRepository.findByEmail(username);
        if (entity.isEmpty()) {
            throw new ResourceNotFoundException(HttpExceptionMessage.MANAGER_IS_NOT_FOUND.name());
        }

        return entity.get().toDTO();
    }

    @Transactional
    public boolean patchSession(final String email, final String session) throws ResourceNotFoundException {

        if (Objects.isNull(email) || Objects.isNull(session)) {
            throw new ResourceNotFoundException("User email and|or session is (are) required.");
        }

        final var oUser = userRepository.findByEmail(email);

        if (oUser.isEmpty()) {
            throw new ResourceNotFoundException("User does NOT exist!");
        }

        final var foundUser = oUser.get();
        if (!foundUser.isActivated()) {
            throw new ResourceNotFoundException("User is not activated!");
        }

        if (!foundUser.isAuthenticated()) {
            throw new ResourceNotFoundException("User is not authenticated!");
        }

        int noOfRowsEffected = 0;
        if (!foundUser.getSession().equalsIgnoreCase(session)) {
            noOfRowsEffected = userRepository.updateSessionByEmail(email, session);
        }

        return noOfRowsEffected > 0;
    }

    @Transactional
    public boolean activate(final String email, final String activation) throws ResourceNotFoundException {

        if (Objects.isNull(email) || Objects.isNull(activation)) {
            throw new ResourceNotFoundException("User email and|or activation request is (are) required.");
        }

        final var oStudent = userRepository.findByEmailAndActivation(email, activation);
        if (oStudent.isEmpty()) {
            return false;
        }

        userRepository.updateActivatedById(Objects.requireNonNull(oStudent.get().getId()), true);
        return true;
    }

    @Transactional
    public boolean deActivate(Long id) throws ResourceNotFoundException {

        if (Objects.isNull(id) || id < 1) {
            throw new ResourceNotFoundException("User activation request is required.");
        }

        final var userExists = userRepository.existsById(id);
        if (userExists) {
            return false;
        }

        userRepository.updateActivatedById(id, true);
        return true;
    }

    @Transactional
    public boolean authenticate(final String email, final String password) throws ResourceNotFoundException {

        if (Objects.isNull(email) || Objects.isNull(password)) {
            throw new ResourceNotFoundException("User activation request is required.");
        }

        final var oStudent = userRepository.findByEmailAndPassword(email, password);
        if (oStudent.isEmpty()) {
            return false;
        }

        userRepository.updateAuthenticatedById(Objects.requireNonNull(oStudent.get().getId()), true);
        return true;
    }

    @Transactional
    public boolean deAuthenticate(Long id) throws ResourceNotFoundException {

        if (Objects.isNull(id) || id < 1) {
            throw new ResourceNotFoundException("User activation request is required.");
        }

        final var userExists = userRepository.existsById(id);
        if (userExists) {
            return false;
        }

        userRepository.updateAuthenticatedById(id, true);
        return true;
    }
}
