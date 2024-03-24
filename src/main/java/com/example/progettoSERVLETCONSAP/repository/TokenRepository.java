package com.example.progettoSERVLETCONSAP.repository;

import com.example.progettoSERVLETCONSAP.model.Token;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

    @Repository
    public interface TokenRepository extends JpaRepository<Token,Integer> {
    }
