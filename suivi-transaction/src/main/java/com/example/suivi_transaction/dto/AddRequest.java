package com.example.suivi_transaction.dto;

import com.example.suivi_transaction.enums.UserRole;
import lombok.Data;

@Data
public class AddRequest {
    private String email ;
    private String password  ;
    private String name  ;
    private String number  ;

}
