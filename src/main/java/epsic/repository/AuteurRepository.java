package epsic.repository;

import epsic.model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {
    @Query("SELECT a FROM Auteur a")
    List<Auteur> findAllAuteurs();
}
