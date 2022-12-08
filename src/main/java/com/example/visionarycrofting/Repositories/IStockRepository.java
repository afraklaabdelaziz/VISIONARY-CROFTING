package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStockRepository extends JpaRepository<Stock,Long> {
}
