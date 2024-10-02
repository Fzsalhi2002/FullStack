package org.cours.jpa.service;

import org.cours.jpa.repository.CoursModuleRepository;
import org.cours.jpa.modele.CoursModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoursModuleService {

    @Autowired
    private CoursModuleRepository coursModuleRepository;

    public List<CoursModule> getAllModules() {
        List<CoursModule> coursModules = new ArrayList<>();
        coursModuleRepository.findAll().forEach(coursModules::add);
        return coursModules;
    }

    public void ajouterModule(CoursModule coursModule) {
        coursModuleRepository.save(coursModule);
    }

    public Optional<CoursModule> getModule(Integer id) {
        return coursModuleRepository.findById(id);
    }

    public void modifierModule(Integer id, CoursModule coursModule) {
        coursModuleRepository.save(coursModule);
    }

    public void supprimerModule(Integer id) {
        coursModuleRepository.deleteById(id);
    }
}
