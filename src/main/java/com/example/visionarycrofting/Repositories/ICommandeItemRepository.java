package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandeItemRepository extends JpaRepository<CommandeItem,Long> {
}
