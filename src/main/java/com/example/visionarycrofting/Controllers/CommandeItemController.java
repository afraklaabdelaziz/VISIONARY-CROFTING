package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.Commande;
import com.example.visionarycrofting.Entities.CommandeItem;
import com.example.visionarycrofting.Entities.Produit;
import com.example.visionarycrofting.Entities.StatusCommande;
import com.example.visionarycrofting.Services.ICommandeItemService;
import com.example.visionarycrofting.Services.ICommandeService;
import com.example.visionarycrofting.Services.IProduitService;
import com.example.visionarycrofting.Utiles.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CommandeItemController {
    @Autowired
    ICommandeItemService commandeItemService;
    @Autowired
    ICommandeService commandeService;
    @Autowired
    IProduitService produitService;
    @PostMapping("/commandeitem/add")
    public String addCommandeItem(@ModelAttribute CommandeItem commandeItem, HttpSession session){
        commandeItemService.save(commandeItem,session);
        return "redirect:/produits";
    }
    @GetMapping("/cart")
    public String allCommandeItems (Model model){
        Commande commandeFind = commandeService.getCommandeClientStatusEncours(1L,StatusCommande.EN_COURS);
        if (commandeFind != null){
             List<CommandeItem> commandeItems = commandeFind.getCommandeItems();
             Float prixTotal = 0F;
             for (CommandeItem commandeItem : commandeItems){
                 prixTotal+= (commandeItem.getPrix()*commandeItem.getQuantity());
             }
             model.addAttribute("commadeItems",commandeItems);
             model.addAttribute("idCommande",commandeFind.getId());
            model.addAttribute("referenceCommande",commandeFind.getReference());
             model.addAttribute("prixTotal",prixTotal);
        }
        return "cart";
    }


}
