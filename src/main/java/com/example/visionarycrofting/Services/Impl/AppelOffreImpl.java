package com.example.visionarycrofting.Services.Impl;

import com.example.visionarycrofting.Entities.AppelOffre;
import com.example.visionarycrofting.Entities.StatusAppelOffre;
import com.example.visionarycrofting.Services.IAppelOffreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AppelOffreImpl implements IAppelOffreService {
    @Override
    public List<AppelOffre> getAppelOffres() {
        return null;
    }

    @Override
    public AppelOffre addAppelOffre(AppelOffre appelOffre) {
        return null;
    }

    @Override
    public boolean deleteAppelOffre(Long id) {
        return false;
    }

    @Override
    public AppelOffre updateAppelOffre(Long id, AppelOffre appelOffre) {
        return null;
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
