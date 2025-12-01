package ch.vd.apprenti.controller.auteur;

import ch.vd.apprenti.beans.AuteurBean;
import ch.vd.apprenti.controller.AbstractController;
import ch.vd.apprenti.model.Auteur;
import ch.vd.apprenti.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = AbstractController.ROOT_API + "/auteur", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuteurController {

    @Autowired
    private AuteurService auteurService;

    @GetMapping("/allAuteurs")
    public List<AuteurBean> getAuteurs() {
        return getAuteurBean(auteurService.getAuteurs());
    }

    private List<AuteurBean> getAuteurBean(List<Auteur> auteurList) {
        List<AuteurBean> auteurBeanList = new ArrayList<>();

        for (Auteur auteur : auteurList) {
            AuteurBean auteurBean = new AuteurBean(auteur.getId(), auteur.getNom(), auteur.getPrenom(), auteur.getNationalite());

            auteurBeanList.add(auteurBean);
        }

        return auteurBeanList;
    }

    @PostMapping("/insertAuteur")
    public void insertAuteur(@RequestBody AuteurBean auteurBean) {
        insertAuteurBean(auteurBean);
    }

    private void insertAuteurBean(AuteurBean auteurBean) {
        Auteur auteur = new Auteur(auteurBean.getNom(), auteurBean.getPrenom(), auteurBean.getNationalite());
        auteurService.saveAuteur(auteur);
    }
}
