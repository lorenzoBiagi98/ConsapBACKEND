package com.example.progettoSERVLETCONSAP.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;

@Data
    @Entity
    public class Token {

        public Token(String descrizione, UserEntity utente){
            this.tokenDescrizione = descrizione;
            this.userEntity = utente;
            this.tokenStatoToken = "Attivo";
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer tokenId;
        @Column(unique = true)
        private String tokenDescrizione;
        private String tokenStatoToken;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="userEntityId", referencedColumnName = "id")
        private UserEntity userEntity;

}
