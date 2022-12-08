package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.CommandeItem;
import com.example.visionarycrofting.Services.ICommandeItemService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeItemImpl implements ICommandeItemService {
    @Override
    public CommandeItem save(CommandeItem commandeItems) {
        return null;
    }

    @Override
    public boolean deleteByRef(String ref) {
        return false;
    }

    @Override
    public CommandeItem findByRef(String ref) {
        return null;
    }

    @Override
    public List<CommandeItem> findAll() {
        return null;
    }

    @Override
    public List<CommandeItem> getCommandeItemByQuantityGreaterThan(int quantity) {
        return null;
    }
}
