package ch.vd.apprenti.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUTEURS")
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "auteur_seq", sequenceName = "seq_auteur", allocationSize = 1)
    private long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "NATIONALITE")
    private String nationalite;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL)
    private Set<Livre> livreSet;

    public Auteur() {
    }

    public Auteur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Livre> getLivreSet() {
        return livreSet;
    }

    public void setLivreSet(Set<Livre> livreSet) {
        this.livreSet = livreSet;
    }

    public void addLivre(Livre livre) {
        if (livreSet == null) {
            livreSet = new HashSet<>();
        }

        livreSet.add(livre);
        livre.setAuteur(this);
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nationalite='" + nationalite + '\'' +
                '}';
    }
}
