package reaktor.reaktorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reaktor.reaktorapp.model.entity.User;
import reaktor.reaktorapp.model.form.RegisterUserForm;
import reaktor.reaktorapp.repository.UserRepository;

@Service
public class UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(RegisterUserForm registerUserForm){
        User user = new User();
        user.setFirstName(registerUserForm.getFirstName());
        user.setLastName(registerUserForm.getLastName());
        user.setPassword(registerUserForm.getPassword());
        user.setEmail(registerUserForm.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);
        return savedUser;
    }


    public User getUser(String email){
        return userRepository.findOneByEmail(email);
    }
}
