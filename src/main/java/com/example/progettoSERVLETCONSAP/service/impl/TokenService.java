    package com.example.progettoSERVLETCONSAP.service.impl;

    import com.example.progettoSERVLETCONSAP.model.Token;
    import com.example.progettoSERVLETCONSAP.model.UserEntity;
    import com.example.progettoSERVLETCONSAP.repository.TokenRepository;
    import com.example.progettoSERVLETCONSAP.repository.UserRepository;
    import com.example.progettoSERVLETCONSAP.service.ITokenService;
    import jakarta.persistence.EntityNotFoundException;
    import lombok.NoArgsConstructor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.NoSuchElementException;

    @Service
    @NoArgsConstructor
    public class TokenService implements ITokenService {

       @Autowired
       TokenRepository tokenRepository;

       @Autowired
        UserRepository userRepository;

        @Override
        public Token addToken(String token, String username){
            UserEntity existingUser = userRepository.findByUsername(username);
            if(existingUser!=null) {
                Token tokenSave = new Token(token, existingUser);
                try{
                    tokenRepository.save(tokenSave);
                }catch (Exception err){
                    System.err.println("IMPOSSIBILE GENERARE IL TOKEN per utente loggato");
                }
            } else{
                throw new NoSuchElementException("Non esiste questo username, impossibile" +
                        "generare un token");
            }

            return null;
        }

        @Override
        public String getToken(String token) {

            return token;
        }

        @Override
        public List<Token> getAll() {
            return null;
        }
    }
