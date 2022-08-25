package wp.mongodb.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wp.mongodb.domain.User;
import wp.mongodb.repository.UserRepository;
import wp.mongodb.services.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
   private  UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById (String id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
