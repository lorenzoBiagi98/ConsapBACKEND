package com.example.progettoSERVLETCONSAP.service;



import com.example.progettoSERVLETCONSAP.model.Token;

import java.util.List;

public interface ITokenService {

    Token addToken(String token,String username);
    //Fare update stato token con @Scheduled!!!
    String getToken(String token);
    List<Token> getAll();
}
