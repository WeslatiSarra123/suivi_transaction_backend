package com.example.suivi_transaction.controller.admin;
import com.example.suivi_transaction.dto.AddRequest;
import com.example.suivi_transaction.entity.User;
import com.example.suivi_transaction.services.admin.user.AgentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class AdminUserController {
    @Autowired
    private AgentService service;
    @GetMapping("/agents")
    public List<User> getAgents() {
   return service.getAgents();
    }
    @PostMapping("/agents/addnew")
    public void addAgent(@RequestBody AddRequest addRequest){
        if(service.hasUserWithEmail(addRequest.getEmail())){
            new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        }
        service.addAgent(addRequest);
    }
    @PutMapping("/agents/{id}/edit")
    public void updateAgent(@PathVariable("id") Long id ,@RequestBody User user){
        service.updateAgent(user);
    }
    @DeleteMapping ("/agents/{id}/delete")
    public void deleteAgent (@PathVariable("id") Long id ){
        service.deleteAgent(id);
    }

}