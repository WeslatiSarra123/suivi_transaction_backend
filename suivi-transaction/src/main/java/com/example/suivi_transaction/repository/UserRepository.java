package com.example.suivi_transaction.repository;

import com.example.suivi_transaction.dto.UserDto;
import com.example.suivi_transaction.entity.User;
import com.example.suivi_transaction.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findFirstByEmail (String email);
    User findFirstByRole(UserRole role);
    List<User> findByRole(UserRole role);






}
