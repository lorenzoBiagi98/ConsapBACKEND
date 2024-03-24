package com.example.progettoSERVLETCONSAP.model;

import com.example.progettoSERVLETCONSAP.auth.RoleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleEntity> roles = new ArrayList<RoleEntity>();

    public UserEntity(String username, String password){
        this.username = username;
        this.password = password;
    }

    public List<String> getStringRoles(UserEntity userEntity){
        List<String> roleString = new ArrayList<>();
        for(RoleEntity role : this.roles){
            roleString.add(role.getName());
        }
        return  roleString;
    }


}
