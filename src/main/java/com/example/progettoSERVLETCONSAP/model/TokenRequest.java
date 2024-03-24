package com.example.progettoSERVLETCONSAP.model;

import lombok.AllArgsConstructor;


public class TokenRequest{
    private String token;
    private String username;

    public TokenRequest(String _token, String _username){
        this.token=_token;
        this.username=_username;
    }

    public String getToken(){
        return this.token;
    }

    public String getUsername(){
        return this.username;
    }
}
