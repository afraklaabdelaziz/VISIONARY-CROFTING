package com.example.visionarycrofting.Services;

import com.example.visionarycrofting.Entities.Category;
import com.example.visionarycrofting.Entities.CommandeItem;
import com.example.visionarycrofting.Entities.Produit;

import java.util.List;

public interface IProduitService {

    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit, Long productId);
    Produit getProduitById(Long id);
    List<Produit> getAllProduits();
    boolean deleteProduit(Long id);
    List<Produit> findProuitsByCategory(Category category);
    void updateProduitQuantity(Produit produit1, CommandeItem commandeItems);

}

