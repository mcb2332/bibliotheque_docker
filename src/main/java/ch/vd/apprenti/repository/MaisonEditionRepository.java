package ch.vd.apprenti.repository;

import ch.vd.apprenti.model.Livre;
import ch.vd.apprenti.model.MaisonEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaisonEditionRepository extends JpaRepository<MaisonEdition, Long> {
    @Query("SELECT me FROM MaisonEdition me")
    List<MaisonEdition> findAllMaisonsEdition();
}
