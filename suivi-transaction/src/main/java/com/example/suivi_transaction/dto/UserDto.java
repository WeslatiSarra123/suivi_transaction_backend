package com.example.suivi_transaction.dto;

import com.example.suivi_transaction.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
public class UserDto {

    private Long id ;
    private String email ;
    private String name  ;
    private UserRole userRole;
    private String password;
    public UserDto() {}


    public UserDto(long id, String username, String email, UserRole role) {
        this.id = id;
        this.name = username;
        this.email = email;
        this.userRole = role;
    }

}
