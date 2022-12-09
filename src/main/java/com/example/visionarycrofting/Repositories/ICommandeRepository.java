package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandeRepository extends JpaRepository<Commande,Long> {
}
