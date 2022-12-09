package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IproduitRepository extends JpaRepository<Produit,Long> {
}
