package epsic.controller.livre;

import epsic.beans.AuteurBean;
import epsic.beans.LivreBean;
import epsic.beans.MaisonEditionBean;
import epsic.controller.AbstractController;
import epsic.model.Auteur;
import epsic.model.Livre;
import epsic.model.MaisonEdition;
import epsic.service.AuteurService;
import epsic.service.LivreService;
import epsic.service.MaisonEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = AbstractController.ROOT_API + "/livre", produces = MediaType.APPLICATION_JSON_VALUE)
public class LivreController {

    @Autowired
    private LivreService livreService;
    @Autowired
    private AuteurService auteurService;
    @Autowired
    private MaisonEditionService maisonEditionService;

    @GetMapping("/allLivres")
    public List<LivreBean> getLivres() {
        return getLivreBean(livreService.getLivres());
    }

    private List<LivreBean> getLivreBean(List<Livre> livreList) {
        List<LivreBean> livreBeanList = new ArrayList<>();

        for (Livre livre : livreList) {
            Auteur auteur = livre.getAuteur();
            MaisonEdition maisonEdition = livre.getMaisonEdition();

            AuteurBean auteurBean = new AuteurBean(auteur.getId(), auteur.getNom(), auteur.getPrenom(), auteur.getNationalite());
            MaisonEditionBean maisonEditionBean = new MaisonEditionBean(maisonEdition.getId(), maisonEdition.getNom(), maisonEdition.getPays());

            LivreBean livreBean = new LivreBean(livre.getId(),
                    livre.getTitre(),
                    livre.getAnneePublication(),
                    livre.getIsbn(),
                    auteurBean,
                    maisonEditionBean);

            livreBeanList.add(livreBean);
        }

        return livreBeanList;
    }

    @PostMapping("/insertLivre")
    public void insertLivre(@RequestBody LivreBean livreBean) {
        insertLivreBean(livreBean);
    }

    private void insertLivreBean(LivreBean livreBean) {
        AuteurBean auteurBean = livreBean.getAuteur();
        MaisonEditionBean maisonEditionBean = livreBean.getMaisonEdition();

        Auteur auteur = new Auteur(auteurBean.getNom(), auteurBean.getPrenom(), auteurBean.getNationalite());
        MaisonEdition maisonEdition = new MaisonEdition(maisonEditionBean.getNom(), maisonEditionBean.getPays());

        Livre livre = new Livre(livreBean.getTitre(), livreBean.getAnneePublication(), livreBean.getIsbn());

        livre.setAuteur(auteur);
        livre.setMaisonEdition(maisonEdition);

        auteur.addLivre(livre);
        maisonEdition.addLivre(livre);

        livreService.saveLivre(livreBean);

    }
}
