INSERT INTO auteurs (nom, prenom, nationalite) VALUES
('Hugo', 'Victor', 'Francaise'),
('Verne', 'Jules', 'Francaise'),
('Orwell', 'George', 'Britannique'),
('Rowling', 'J.K.', 'Britannique'),
('Camus', 'Albert', 'Francaise');

INSERT INTO maisonsedition (nom, pays) VALUES
('Gallimard', 'France'),
('Hachette', 'France'),
('Penguin Books', 'Royaume-Uni'),
('Bloomsbury', 'Royaume-Uni'),
('Actes Sud', 'France');

INSERT INTO livres (titre, anneepublication, isbn, fk_auteur_id, fk_maisonedition_id) VALUES
('Les Miserables', 1862, '9782070409189', 1, 1),
('Vingt mille lieues sous les mers', 1870, '9782253006329', 2, 2),
('1984', 1949, '9780451524935', 3, 3),
('Harry Potter à l''ecole des sorciers', 1997, '9780747532699', 4, 4),
('L''Etranger', 1942, '9782070360022', 5, 5);
