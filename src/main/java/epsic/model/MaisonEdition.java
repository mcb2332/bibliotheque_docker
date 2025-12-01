package epsic.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MAISONSEDITION")
public class MaisonEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "maisonEdition_seq", sequenceName = "seq_maisonEdition", allocationSize = 1)
    private long id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PAYS")
    private String pays;

    @OneToMany(mappedBy = "maisonEdition", cascade = CascadeType.ALL)
    private Set<Livre> livreSet;

    public MaisonEdition() {
    }

    public MaisonEdition(String nom, String pays) {
        this.nom = nom;
        this.pays = pays;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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
        livre.setMaisonEdition(this);
    }

    @Override
    public String toString() {
        return "MaisonEdition{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
