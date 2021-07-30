package be.intecbrussel.testy.service;

import be.intecbrussel.testy.mapper.UserMapper;
import be.intecbrussel.testy.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends UserService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(StudentService.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public StudentService(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

}
