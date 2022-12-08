package com.example.visionarycrofting.Services;

import com.example.visionarycrofting.Entities.AppelOffre;
import com.example.visionarycrofting.Entities.StatusAppelOffre;

import java.util.List;
import java.util.Optional;

public interface IAppelOffreService {
    public List<AppelOffre> getAppelOffres();

    public AppelOffre addAppelOffre(AppelOffre appelOffre);

    public boolean deleteAppelOffre(Long id);

    public AppelOffre updateAppelOffre(Long id, AppelOffre appelOffre);

    public List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre);

    Optional<AppelOffre> findById(Long id);
}
