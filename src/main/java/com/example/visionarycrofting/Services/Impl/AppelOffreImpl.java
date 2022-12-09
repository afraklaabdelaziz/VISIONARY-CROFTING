package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.AppelOffre;
import com.example.visionarycrofting.Entities.StatusAppelOffre;
import com.example.visionarycrofting.Repositories.IAppelOffreRepository;
import com.example.visionarycrofting.Services.IAppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AppelOffreImpl implements IAppelOffreService {
    @Autowired
    IAppelOffreRepository appelOffreRepository;
    @Override
    public List<AppelOffre> getAppelOffres() {
        return appelOffreRepository.findAll();
    }

    @Override
    public AppelOffre addAppelOffre(AppelOffre appelOffre) {
        appelOffreRepository.save(appelOffre);
        return appelOffre;
    }

    @Override
    public boolean deleteAppelOffre(Long id) {
         appelOffreRepository.deleteById(id);
        return true;
    }

    @Override
    public AppelOffre updateAppelOffre(Long id, AppelOffre appelOffre) {
        appelOffreRepository.save(appelOffre);
        return appelOffre;
    }

    @Override
    public List<AppelOffre> findByStatusAppelOffre(StatusAppelOffre statusAppelOffre) {
        return null;
    }

    @Override
    public Optional<AppelOffre> findById(Long id) {
        return Optional.empty();
    }
}
