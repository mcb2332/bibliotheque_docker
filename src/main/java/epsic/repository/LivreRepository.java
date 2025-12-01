package epsic.repository;

import epsic.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    @Query("SELECT l FROM Livre l")
    List<Livre> findAllLivres();
}
