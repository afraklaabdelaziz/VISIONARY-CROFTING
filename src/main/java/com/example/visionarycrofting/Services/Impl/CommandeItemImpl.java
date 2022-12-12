package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.*;
import com.example.visionarycrofting.Repositories.ICommandeItemRepository;
import com.example.visionarycrofting.Services.ICommandeItemService;
import com.example.visionarycrofting.Services.ICommandeService;
import com.example.visionarycrofting.Services.IProduitService;
import com.example.visionarycrofting.Utiles.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
@Service
public class CommandeItemImpl implements ICommandeItemService {

    @Autowired
    ICommandeItemRepository commandeItemRepository;
    @Autowired
    ICommandeService commandeService;
    @Autowired
    IProduitService produitService;


    @Override
    public CommandeItem save(CommandeItem commandeItem, HttpSession session) {
        Client client = (Client) session.getAttribute("client");
        Commande commandeFind = commandeService.getCommandeClientStatusEncours(client.getId(), StatusCommande.EN_COURS);
        CommandeItem commandeItemFind = this.findByRef("2R5JX63V");
        if(commandeFind != null){
            commandeItem.setCommande(commandeFind);
        }else {
            Commande commande = new Commande();
            commande.setReference(GenerateReference.applyGenerateReference());
            commande.setClient(client);
            commande.setDate(LocalDate.now());
            commande.setPrixTotal(0F);
            commande.setStatus(StatusCommande.EN_COURS);
            commandeService.save(commande);
            commandeItem.setCommande(commande);
        }
        if(commandeItemFind != null && commandeFind != null){
            commandeItemFind.setQuantity(commandeItem.getQuantity()+ commandeItemFind.getQuantity());
            commandeItemFind.setPrix(commandeItemFind.getPrix()* commandeItemFind.getQuantity());
            Produit produit = produitService.getProduitById(commandeItemFind.getProduit().getId());
            produit.setQuantity(produit.getQuantity() - commandeItemFind.getQuantity());
            produitService.addProduit(produit);
            commandeItemRepository.save(commandeItemFind);
            return commandeItem;
        }else {
            commandeItem.setReference(GenerateReference.applyGenerateReference());
            commandeItemRepository.save(commandeItem);
            Produit produit = produitService.getProduitById(commandeItem.getProduit().getId());
            produit.setQuantity(produit.getQuantity() - commandeItem.getQuantity());
            produitService.addProduit(produit);
            return commandeItem;
        }


    }

    @Override
    public boolean deleteByRef(String ref) {
        return false;
    }

    @Override
    public CommandeItem findByRef(String ref) {
        return commandeItemRepository.findCommandeItemsByReference(ref);
    }

    @Override
    public List<CommandeItem> findAll() {
        return commandeItemRepository.findAll();
    }

    @Override
    public List<CommandeItem> getCommandeItemByQuantityGreaterThan(int quantity) {
        return null;
    }
}
