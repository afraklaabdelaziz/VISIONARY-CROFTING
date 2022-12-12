package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.AppelOffre;
import com.example.visionarycrofting.Entities.Produit;
import com.example.visionarycrofting.Entities.StatusAppelOffre;
import com.example.visionarycrofting.Services.IAppelOffreService;
import com.example.visionarycrofting.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appelOffre")
public class AppelOffreController {
    @Autowired
    IAppelOffreService appelOffreService;
    @Autowired
    IProduitService produitService;
    @PostMapping("/")
    public String appelOffre(@ModelAttribute AppelOffre appelOffre){
        System.out.println(appelOffre.getFournisseur());
        appelOffre.setStatusAppelOffre(StatusAppelOffre.VALIDE);
        appelOffreService.addAppelOffre(appelOffre);
       Produit produit =  produitService.getProduitById(appelOffre.getProduit().getId());
       produit.setQuantity(produit.getQuantity()+ appelOffre.getQuantity());
       produitService.addProduit(produit);
        return "redirect:/fournisseur/allappeloffres";
    }
}
