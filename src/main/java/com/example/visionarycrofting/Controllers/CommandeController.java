package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.Commande;
import com.example.visionarycrofting.Entities.StatusCommande;
import com.example.visionarycrofting.Services.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    ICommandeService commandeService;
    @PostMapping("/update")
    public String updateCommande(@ModelAttribute Commande commande){
        commande.setStatus(StatusCommande.EFFECTUER);
        commandeService.save(commande);
        return "redirect:/produits";
    }
}
