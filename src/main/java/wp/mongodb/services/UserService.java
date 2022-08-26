package wp.mongodb.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wp.mongodb.domain.User;
import wp.mongodb.dto.UserDTO;
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
    public User insert (User obj ){
      return userRepository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update (User obj){
        User newObj = userRepository.findById(obj.getId()).get();
        updateData(newObj,obj);
        return  userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());

    }

    public User fromDTO (UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }
}
