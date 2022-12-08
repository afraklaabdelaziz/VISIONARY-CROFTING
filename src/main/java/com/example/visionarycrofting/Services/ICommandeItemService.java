package com.example.visionarycrofting.Services;

import com.example.visionarycrofting.Entities.CommandeItem;

import java.util.List;

public interface ICommandeItemService {
    CommandeItem save(CommandeItem commandeItems);

    boolean deleteByRef(String ref);

    CommandeItem findByRef(String ref);

    List<CommandeItem> findAll();

    List<CommandeItem> getCommandeItemByQuantityGreaterThan(int quantity);
}
