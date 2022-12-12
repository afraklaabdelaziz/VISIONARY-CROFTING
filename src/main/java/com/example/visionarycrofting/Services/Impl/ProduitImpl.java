package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.Category;
import com.example.visionarycrofting.Entities.CommandeItem;
import com.example.visionarycrofting.Entities.Produit;
import com.example.visionarycrofting.Repositories.IproduitRepository;
import com.example.visionarycrofting.Services.IProduitService;
import com.example.visionarycrofting.Utiles.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitImpl implements IProduitService {
    @Autowired
    IproduitRepository produitRepository;
    @Override
    public Produit addProduit(Produit produit) {
        if (produit == null){
            System.out.println("ce produit est null");
            return null;
        }else if(produit.getNom() == null || produit.getDescription() == null ||
                produit.getCategory() == null || produit.getPrixInitial() == null ||
         produit.getQuantity() == null || produit.getQuantity()<0){
            System.out.println("compliter les information");
            return null;
        }else {
            produit.setReference(GenerateReference.applyGenerateReference());
            produitRepository.save(produit);
        }
        return produit;
    }

    @Override
    public Produit updateProduit(Produit produit, Long productId) {
        return null;
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public boolean deleteProduit(Long id) {
        return false;
    }

    @Override
    public List<Produit> findProuitsByCategory(Category category) {
        return null;
    }

    @Override
    public void updateProduitQuantity(Produit produit1, CommandeItem commandeItems) {

    }
}
