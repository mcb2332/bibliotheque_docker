package ch.vd.apprenti.service;

import ch.vd.apprenti.model.MaisonEdition;
import ch.vd.apprenti.repository.MaisonEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaisonEditionService {

    private MaisonEditionRepository maisonEditionRepository;

    @Autowired
    public MaisonEditionService(MaisonEditionRepository maisonEditionRepository) {
        this.maisonEditionRepository = maisonEditionRepository;
    }

    public MaisonEditionService() {
    }

    @Transactional
    public void saveMaisonEdition(MaisonEdition maisonEdition) {
        maisonEditionRepository.save(maisonEdition);
    }

    @Transactional
    public List<MaisonEdition> getMaisonsEdition() {
        return maisonEditionRepository.findAllMaisonsEdition();
    }
}
