package com.example.progettoSERVLETCONSAP.repository;


import com.example.progettoSERVLETCONSAP.auth.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
  RoleEntity findByName(String name);
}
