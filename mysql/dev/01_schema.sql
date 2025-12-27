CREATE TABLE IF NOT EXISTS auteurs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    nationalite VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS maisons_edition (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(150) NOT NULL,
    pays VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS livres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(200) NOT NULL,
    annee_publication INT NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    auteur_id INT NOT NULL,
    maison_edition_id INT NOT NULL,

    CONSTRAINT fk_livre_auteur
        FOREIGN KEY (auteur_id) REFERENCES auteurs(id),

    CONSTRAINT fk_livre_maison_edition
        FOREIGN KEY (maison_edition_id) REFERENCES maisons_edition(id)
);