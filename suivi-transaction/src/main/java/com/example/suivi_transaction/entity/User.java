package com.example.suivi_transaction.entity;

import com.example.suivi_transaction.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


    @Entity
    @Data
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String name;
        private String number;
        private String email;
        private String password;
        @Enumerated(EnumType.STRING)
        private UserRole role;




    }
