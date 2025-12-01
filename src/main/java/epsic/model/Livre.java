package epsic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "LIVRES")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "livre_seq", sequenceName = "seq_livre", allocationSize = 1)
    private long id;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "ANNEEPUBLICATION")
    private long anneePublication;

    @Column(name = "ISBN", unique = true)
    private long isbn;

    @ManyToOne
    @JoinColumn(name = "FK_AUTEUR_ID", nullable = false, foreignKey = @ForeignKey(name = "LIVRE_AUTEUR_FK"))
    private Auteur auteur;

    @ManyToOne
    @JoinColumn(name = "FK_MAISONEDITION_ID", nullable = false, foreignKey = @ForeignKey(name = "LIVRE_MAISONEDITION_FK"))
    private MaisonEdition maisonEdition;

    public Livre() {
    }

    public Livre(String titre, long anneePublication, long isbn) {
        this.titre = titre;
        this.anneePublication = anneePublication;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public long getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(long anneePublication) {
        this.anneePublication = anneePublication;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public MaisonEdition getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEdition maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", anneePublication=" + anneePublication +
                ", isbn=" + isbn +
                ", auteur=" + auteur.toString() +
                ", maisonEdition=" + maisonEdition.toString() +
                '}';
    }
}
