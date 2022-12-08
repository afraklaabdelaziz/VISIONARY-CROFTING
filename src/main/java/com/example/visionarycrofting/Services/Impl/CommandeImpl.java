package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.Commande;
import com.example.visionarycrofting.Entities.CommandeItem;
import com.example.visionarycrofting.Services.ICommandeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommandeImpl implements ICommandeService {
    @Override
    public Commande save(Commande commande) {
        return null;
    }

    @Override
    public List<Commande> findAll() {
        return null;
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Commande findByReference(String ref) {
        return null;
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
}
