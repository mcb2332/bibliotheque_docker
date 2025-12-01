package epsic.controller.maisonEdition;

import epsic.beans.MaisonEditionBean;
import epsic.controller.AbstractController;
import epsic.model.MaisonEdition;
import epsic.service.MaisonEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = AbstractController.ROOT_API + "/maisonEdition", produces = MediaType.APPLICATION_JSON_VALUE)
public class MaisonEditionController {

    @Autowired
    private MaisonEditionService maisonEditionService;

    @GetMapping("/allMaisonsEdition")
    public List<MaisonEditionBean> getMaisonsEdition() {
        return getMaisonEditionBean(maisonEditionService.getMaisonsEdition());
    }

    private List<MaisonEditionBean> getMaisonEditionBean(List<MaisonEdition> maisonEditionList) {
        List<MaisonEditionBean> maisonEditionBeanList = new ArrayList<>();

        for (MaisonEdition maisonEdition : maisonEditionList) {
            MaisonEditionBean maisonEditionBean = new MaisonEditionBean(maisonEdition.getId(), maisonEdition.getNom(), maisonEdition.getPays());

            maisonEditionBeanList.add(maisonEditionBean);
        }

        return maisonEditionBeanList;
    }

    @PostMapping("/insertMaisonEdition")
    public void insertAuteur(@RequestBody MaisonEditionBean maisonEditionBean) {
        insertMaisonEditionBean(maisonEditionBean);
    }

    private void insertMaisonEditionBean(MaisonEditionBean maisonEditionBean) {
        MaisonEdition maisonEdition = new MaisonEdition(maisonEditionBean.getNom(), maisonEditionBean.getPays());
        maisonEditionService.saveMaisonEdition(maisonEdition);
    }

}
