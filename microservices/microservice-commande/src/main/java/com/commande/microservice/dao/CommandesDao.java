package com.commande.microservice.dao;

import com.commande.microservice.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandesDao extends JpaRepository<Commande, Integer> {
}
