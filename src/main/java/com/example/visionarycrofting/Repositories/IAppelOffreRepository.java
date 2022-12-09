package com.example.visionarycrofting.Repositories;

import com.example.visionarycrofting.Entities.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppelOffreRepository extends JpaRepository<AppelOffre,Long> {
}
