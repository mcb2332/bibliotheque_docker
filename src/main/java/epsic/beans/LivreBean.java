package epsic.beans;

public class LivreBean {
    private long id;

    private String titre;

    private long anneePublication;

    private long isbn;

    private AuteurBean auteur;

    private MaisonEditionBean maisonEdition;

    public LivreBean(long id, String titre, long anneePublication, long isbn, AuteurBean auteurBean, MaisonEditionBean maisonEditionBean) {
        this.id = id;
        this.titre = titre;
        this.anneePublication = anneePublication;
        this.isbn = isbn;
        this.auteur = auteurBean;
        this.maisonEdition = maisonEditionBean;
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

    public AuteurBean getAuteur() {
        return auteur;
    }

    public void setAuteur(AuteurBean auteur) {
        this.auteur = auteur;
    }

    public MaisonEditionBean getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEditionBean maisonEdition) {
        this.maisonEdition = maisonEdition;
    }
}
