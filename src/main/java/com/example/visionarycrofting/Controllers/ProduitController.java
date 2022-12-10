package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.Produit;
import com.example.visionarycrofting.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
