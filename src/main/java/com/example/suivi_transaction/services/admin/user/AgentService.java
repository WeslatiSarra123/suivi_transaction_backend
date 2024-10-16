package com.example.suivi_transaction.services.admin.user;

import com.example.suivi_transaction.dto.AddRequest;
import com.example.suivi_transaction.entity.User;
import com.example.suivi_transaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.suivi_transaction.enums.UserRole;

import java.util.List;

@Service
public class AgentService {
    @Autowired
    private UserRepository repository;

    public List<User> getAgents(){
        return repository.findByRole(UserRole.AGENT);

    }
    public Boolean hasUserWithEmail(String email){

        return repository.findFirstByEmail(email).isPresent();
    }
    public void addAgent(AddRequest addRequest ){
        User user = new User();
        user.setEmail(addRequest.getEmail());
        user.setName(addRequest.getName());
        user.setNumber(addRequest.getNumber());
        user.setPassword(new BCryptPasswordEncoder().encode(addRequest.getPassword()));
        user.setRole(UserRole.AGENT);
        repository.save(user);
    }
    public void updateAgent(User user){
        repository.save(user);
    }
    public void deleteAgent(Long id){
        repository.deleteById(id);
    }
}
