package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.Commande;
import com.example.visionarycrofting.Entities.CommandeItem;
import com.example.visionarycrofting.Entities.Produit;
import com.example.visionarycrofting.Entities.StatusCommande;
import com.example.visionarycrofting.Services.ICommandeService;
import com.example.visionarycrofting.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    ICommandeService commandeService;
    @Autowired
    IProduitService produitService;
    @PostMapping("/update")
    public String updateCommande(@ModelAttribute Commande commande){
        commandeService.updateCommande(commande);
        return "redirect:/produits";
    }
}
