package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.Produit;
import com.example.visionarycrofting.Services.IProduitService;
import com.example.visionarycrofting.Utiles.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produits")
public class ProduitController {
    @Autowired
    IProduitService produitService;
    @GetMapping
    public String allProduit(Model model){
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits",produits);
        return "produits";
    }

    @GetMapping("/produit/{id}")
    public String produit(@PathVariable Long id, Model model){
        Produit produit = produitService.getProduitById(id);
        model.addAttribute("produit",produit);
        return "produit";
    }
}
