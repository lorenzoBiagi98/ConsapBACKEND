package com.example.progettoSERVLETCONSAP.service;



import com.example.progettoSERVLETCONSAP.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserEntity save(UserEntity user);
    UserEntity addRoleToUser(String username, String roleName);
    List<UserEntity> findAll();
    UserEntity findByUsername(String username);

}
