package com.example.suivi_transaction.services.auth;


import com.example.suivi_transaction.dto.SignupRequest;
import com.example.suivi_transaction.dto.UserDto;
import com.example.suivi_transaction.entity.User;
import com.example.suivi_transaction.enums.UserRole;
import com.example.suivi_transaction.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(SignupRequest signupRequest){
        User user= new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setNumber(signupRequest.getNumber());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.USER);
        User createdUser = userRepository.save(user);
        UserDto userDto= new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }


    public Boolean hasUserWithEmail(String email){
       return userRepository.findFirstByEmail(email).isPresent();
    }
    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findFirstByRole(UserRole.ADMIN);
        if(null== adminAccount){
            User user = new User();
            user.setEmail("admin@test.com");
            user.setName("admin");
            user.setNumber("53583076");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin12"));
            userRepository.save(user);

        }
    }
}
