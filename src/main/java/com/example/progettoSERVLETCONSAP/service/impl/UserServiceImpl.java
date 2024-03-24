package com.example.progettoSERVLETCONSAP.service.impl;



import com.example.progettoSERVLETCONSAP.auth.RoleEntity;
import com.example.progettoSERVLETCONSAP.model.UserEntity;
import com.example.progettoSERVLETCONSAP.repository.RoleRepository;
import com.example.progettoSERVLETCONSAP.repository.UserRepository;
import com.example.progettoSERVLETCONSAP.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

        private static final String USER_NOT_FOUND_MESSAGE = "User with username %s not found";

        @Autowired
        UserRepository userJpaRepository;
    @Autowired
    RoleRepository roleJpaRepository;

        private final PasswordEncoder passwordEncoder;

        @Override
        public UserEntity save(UserEntity user) {
            log.info("Saving user {} to the database", user.getUsername());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userJpaRepository.save(user);
        }


        @Override
        public UserEntity addRoleToUser(String username, String roleName) {
            log.info("Adding role {} to user {}", roleName, username);
            UserEntity userEntity = userJpaRepository.findByUsername(username);
            RoleEntity roleEntity = roleJpaRepository.findByName(roleName);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            System.out.println(auth);
            if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                userEntity.getRoles().add(roleEntity);
            }else{
                throw  new AuthorizationServiceException("Non hai i permessi!");
            }

            return userEntity;

    }

    @Override
    public List<UserEntity> findAll() {
        return userJpaRepository
                .findAll();
    }

    @Override
    public UserEntity findByUsername(String username) {
            try {
                return userJpaRepository.findByUsername(username);
            }catch (Exception err){
                throw  new EntityNotFoundException("Nessun utente trovato con questo username");
            }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userJpaRepository.findByUsername(username);
        if(user == null) {
            String message = String.format(USER_NOT_FOUND_MESSAGE, username);
            log.error(message);
            throw new UsernameNotFoundException(message);
        } else {
            log.debug("User found in the database: {}", username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new User(user.getUsername(), user.getPassword(), authorities);
        }
    }
}
