package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client,Long> {
}
