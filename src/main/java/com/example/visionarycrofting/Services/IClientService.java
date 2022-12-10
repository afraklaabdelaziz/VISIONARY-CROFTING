package com.example.visionarycrofting.Services;

import com.example.visionarycrofting.Entities.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Client save(Client client);
    List<Client> findAll();
    boolean deleteById(Long id);

    Optional<Client> findById(Long id);

    Client findByEmail(String email);

    Client loginClient(String email,String password);

}
