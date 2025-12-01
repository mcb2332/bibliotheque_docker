package ch.vd.apprenti.service;

import ch.vd.apprenti.beans.LivreBean;
import ch.vd.apprenti.model.Livre;
import ch.vd.apprenti.repository.AuteurRepository;
import ch.vd.apprenti.repository.LivreRepository;
import ch.vd.apprenti.repository.MaisonEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivreService {

    private LivreRepository livreRepository;
    private AuteurRepository auteurRepository;
    private MaisonEditionRepository maisonEditionRepository;

    @Autowired
    public LivreService(LivreRepository livreRepository, AuteurRepository auteurRepository, MaisonEditionRepository maisonEditionRepository) {
        this.livreRepository = livreRepository;
        this.auteurRepository = auteurRepository;
        this.maisonEditionRepository = maisonEditionRepository;
    }

    public LivreService() {
    }

    @Transactional
    public void saveLivre(LivreBean livreBean) {
        Livre newLivre = new Livre();
        newLivre.setTitre(livreBean.getTitre());
        newLivre.setAnneePublication(livreBean.getAnneePublication());
        newLivre.setIsbn(livreBean.getIsbn());
        newLivre.setAuteur(auteurRepository.findById(livreBean.getAuteur().getId()).orElse(null));
        newLivre.setMaisonEdition(maisonEditionRepository.findById(livreBean.getMaisonEdition().getId()).orElse(null));

        livreRepository.save(newLivre);
    }

    @Transactional
    public List<Livre> getLivres() {
        return livreRepository.findAllLivres();
    }
}
