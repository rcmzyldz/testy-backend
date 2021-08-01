package be.intecbrussel.testy.service;

import be.intecbrussel.testy.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends UserService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(StudentService.class);
    private final UserRepository userRepository;

    public StudentService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

}
