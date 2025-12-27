INSERT INTO auteur (nom, prenom, nationalite) VALUES
('Hugo', 'Victor', 'Française'),
('Verne', 'Jules', 'Française'),
('Orwell', 'George', 'Britannique'),
('Rowling', 'J.K.', 'Britannique'),
('Camus', 'Albert', 'Française');

INSERT INTO maison_edition (nom, pays) VALUES
('Gallimard', 'France'),
('Hachette', 'France'),
('Penguin Books', 'Royaume-Uni'),
('Bloomsbury', 'Royaume-Uni'),
('Actes Sud', 'France');

INSERT INTO livre (titre, annee_publication, isbn, auteur_id, maison_edition_id) VALUES
('Les Misérables', 1862, '9782070409189', 1, 1),
('Vingt mille lieues sous les mers', 1870, '9782253006329', 2, 2),
('1984', 1949, '9780451524935', 3, 3),
('Harry Potter à l''école des sorciers', 1997, '9780747532699', 4, 4),
('L''Étranger', 1942, '9782070360022', 5, 5);
