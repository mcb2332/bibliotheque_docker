CREATE TABLE IF NOT EXISTS auteurs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    nationalite VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS maisonsedition (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(150) NOT NULL,
    pays VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS livres (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(200) NOT NULL,
    anneepublication BIGINT NOT NULL,
    isbn BIGINT NOT NULL,
    fk_auteur_id BIGINT NOT NULL,
    fk_maisonedition_id BIGINT NOT NULL,

    CONSTRAINT livre_auteur_fk
        FOREIGN KEY (fk_auteur_id) REFERENCES auteurs(id),

    CONSTRAINT livre_maisonedition_fk
        FOREIGN KEY (fk_maisonedition_id) REFERENCES maisonsedition(id)
);