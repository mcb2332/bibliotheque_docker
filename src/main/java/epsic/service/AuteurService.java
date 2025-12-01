package epsic.service;

import epsic.model.Auteur;
import epsic.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuteurService {

    private AuteurRepository auteurRepository;

    @Autowired
    public AuteurService(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    public AuteurService() {
    }

    @Transactional
    public void saveAuteur(Auteur auteur) {
        auteurRepository.save(auteur);
    }

    @Transactional
    public List<Auteur> getAuteurs() {
        return auteurRepository.findAllAuteurs();
    }

}
