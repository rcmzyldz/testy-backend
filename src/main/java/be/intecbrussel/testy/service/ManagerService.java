package be.intecbrussel.testy.service;

import be.intecbrussel.testy.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ManagerService extends UserService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ManagerService.class);
    private final UserRepository userRepository;

    public ManagerService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }


}
