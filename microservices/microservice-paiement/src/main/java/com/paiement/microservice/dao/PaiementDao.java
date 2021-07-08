package com.paiement.microservice.dao;

import com.paiement.microservice.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Integer>{

    Paiement findByidCommande(int idCommande);
}
