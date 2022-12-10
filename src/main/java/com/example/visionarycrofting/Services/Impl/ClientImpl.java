package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.Client;
import com.example.visionarycrofting.Repositories.IClientRepository;
import com.example.visionarycrofting.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientImpl implements IClientService {
    @Autowired
    IClientRepository clientRepository;
    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Client findByEmail(String email) {
        return null;
    }

    @Override
    public Client loginClient(String email, String password) {
        return null;
    }
}
