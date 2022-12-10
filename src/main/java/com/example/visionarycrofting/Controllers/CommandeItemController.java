package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.Commande;
import com.example.visionarycrofting.Entities.CommandeItem;
import com.example.visionarycrofting.Services.ICommandeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommandeItemController {
    @Autowired
    ICommandeItemService commandeItemService;
    @PostMapping("/commandeitem/add")
    public String addCommandeItem(@ModelAttribute CommandeItem commandeItem){
        commandeItemService.save(commandeItem);
        return "redirect:/produits";
    }
    @GetMapping("/cart")
    public String allCommandeItems (){

    }


}
