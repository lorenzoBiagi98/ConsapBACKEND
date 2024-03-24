package com.example.progettoSERVLETCONSAP.controller;



import com.example.progettoSERVLETCONSAP.model.Token;
import com.example.progettoSERVLETCONSAP.model.TokenRequest;
import com.example.progettoSERVLETCONSAP.service.ITokenService;
import com.example.progettoSERVLETCONSAP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("token")
public class TokenController {

    @Autowired
    ITokenService tokenService;

    @Autowired
    private UserService userService;
/*
    @PostMapping
    public ResponseEntity<Token> addToken(@RequestBody TokenRequest request){
        Token token = new Token(request.getToken(), userService.findByUsername(request.getUsername()));
        return new ResponseEntity<Token>(tokenService.addToken(token), HttpStatus.OK);
    }

 */
}
