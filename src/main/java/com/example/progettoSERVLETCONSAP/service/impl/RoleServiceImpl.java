package com.example.progettoSERVLETCONSAP.service.impl;

import com.example.progettoSERVLETCONSAP.auth.RoleEntity;
import com.example.progettoSERVLETCONSAP.repository.RoleRepository;
import com.example.progettoSERVLETCONSAP.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Override
    public RoleEntity save(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }
}
