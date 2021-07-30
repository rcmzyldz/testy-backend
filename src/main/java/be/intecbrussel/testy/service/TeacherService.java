package be.intecbrussel.testy.service;

import be.intecbrussel.testy.mapper.UserMapper;
import be.intecbrussel.testy.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends UserService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TeacherService.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public TeacherService(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

}
