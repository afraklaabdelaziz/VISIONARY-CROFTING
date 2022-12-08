package com.example.visionarycrofting.Services;

import com.example.visionarycrofting.Entities.Commande;
import com.example.visionarycrofting.Entities.CommandeItem;

import java.util.List;
import java.util.Optional;

public interface ICommandeService {
    Commande save(Commande commande);
    List<Commande> findAll();
    Optional<Commande> findById(Long id);
    Commande findByReference(String ref);
    List<Commande> findEffectuedCommands();
    Commande updateCommandePrix(Commande commande);
    void saveCommandeItems(Commande commande , List<CommandeItem> commandeItems);

}
