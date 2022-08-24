package wp.mongodb.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wp.mongodb.domain.User;
import wp.mongodb.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
   private  UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}