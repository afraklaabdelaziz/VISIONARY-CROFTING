package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.Commande;
import com.example.visionarycrofting.Entities.CommandeItem;
import com.example.visionarycrofting.Entities.StatusCommande;
import com.example.visionarycrofting.Repositories.ICommandeRepository;
import com.example.visionarycrofting.Services.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeImpl implements ICommandeService {
    @Autowired
    ICommandeRepository commandeRepository;
    @Override
    public Commande save(Commande commande) {
        if (commande == null){
            System.out.println("commande null");
            return null;
        }else if (commande.getClient() == null || commande.getReference().equals("")) {
            return null;
        }
        else {
            commande.setDate(LocalDate.now());
            commandeRepository.save(commande);
            return commande;
        }
    }

    @Override
    public List<Commande> findAll() {
        return null;
    }

    @Override
    public Commande findById(Long id) {
        if (id < 0){
            System.out.println("error id");
            return new Commande();
        }
        return commandeRepository.findById(id).get();
    }

    @Override
    public Commande findByReference(String ref) {
        return commandeRepository.findCommandeByReference(ref);
    }

    @Override
    public List<Commande> findEffectuedCommands() {
        return null;
    }

    @Override
    public Commande updateCommandePrix(Commande commande) {
        return null;
    }

    @Override
    public void saveCommandeItems(Commande commande, List<CommandeItem> commandeItems) {

    }

    @Override
    public Commande getCommandeClientStatusEncours(Long idClient, StatusCommande status) {
        return commandeRepository.getCommadeClient(idClient,status);
    }
}
