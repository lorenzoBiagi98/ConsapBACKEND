package com.example.progettoSERVLETCONSAP.controller;

import com.example.progettoSERVLETCONSAP.JwtUtil;
import com.example.progettoSERVLETCONSAP.model.UserEntity;
import com.example.progettoSERVLETCONSAP.service.impl.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity userEntity){

        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userEntity.getUsername(),
                            userEntity.getPassword()));
            String accessToken = JwtUtil.createAccessToken(userEntity.getUsername(),
                    "LorenzoBiagiSRL", userEntity.getStringRoles(userEntity));
            String refreshToken = JwtUtil.createRefreshToken(userEntity.getUsername());

            try{
                tokenService.addToken(accessToken,userEntity.getUsername());
            }catch(Exception err){
                err.printStackTrace();
            }


            return ResponseEntity.ok()
                    .header("access_token",accessToken)
                    .header("refresh_token", refreshToken)
                    .body("Login effettuato correttamente, bentornato: " + userEntity.getUsername());
        }catch (Exception err){
            System.out.println("Non autorizzato!!!");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login non effettuato");
        }
    }
    /*
    public ResponseEntity<String> login(@RequestBody UserEntity userEntity){

        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userEntity.getUsername(),
                            userEntity.getPassword()));
            String accessToken = JwtUtil.createAccessToken(userEntity.getUsername(),
                    "LorenzoBiagiSRL", userEntity.getStringRoles(userEntity));
            String refreshToken = JwtUtil.createRefreshToken(userEntity.getUsername());
            UserEntity existingUser = userRepository.findByUsername(userEntity.getUsername());


            Token token = new Token(accessToken,existingUser);
            try{
                tokenRepository.save(token);
            }catch(Exception err){
               err.printStackTrace();
            }


            return ResponseEntity.ok()
                    .header("access_token",accessToken)
                    .header("refresh_token", refreshToken)
                    .body("Login effettuato correttamente");
        }catch (Exception err){
            System.out.println("Non autorizzato!!!");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login non effettuato");
        }
    }
    */



}
