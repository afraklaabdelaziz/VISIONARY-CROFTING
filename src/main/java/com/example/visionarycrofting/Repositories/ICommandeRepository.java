package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommandeRepository extends JpaRepository<Commande,Long> {
}
