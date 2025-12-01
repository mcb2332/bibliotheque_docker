# Exercice Hibernate – Gestion d’une Bibliothèque

## Objectif
Mettre en place une petite base de données avec Hibernate en utilisant les relations **OneToMany** et **ManyToOne**.

---

## Contexte
On veut modéliser une bibliothèque.  
Chaque Auteur peut écrire plusieurs Livres, et chaque Livre peut être édité par une Maison d’édition.  
Une maison d’édition publie plusieurs livres, mais un livre n’a qu’un seul éditeur.

---

## Entités à modéliser

### Auteur
- id (clé primaire)
- nom
- prénom
- nationalité

### Livre
- id (clé primaire)
- titre
- annéePublication
- isbn (unique)
- relation : un Livre appartient à un seul Auteur (ManyToOne)
- relation : un Livre appartient à une seule Maison d’édition (ManyToOne)

### MaisonEdition
- id (clé primaire)
- nom
- pays

---

## Relations à implémenter
- Un Auteur peut écrire plusieurs Livres  
  -> relation OneToMany (Auteur ? Livre).
- Un Livre appartient à un seul Auteur  
  -> relation ManyToOne (Livre ? Auteur).
- Une Maison d’édition publie plusieurs Livres  
  -> relation OneToMany (MaisonEdition ? Livre).
- Un Livre appartient à une seule Maison d’édition  
  -> relation ManyToOne (Livre ? MaisonEdition).

---

## Travail demandé
1. Créez les classes Java correspondantes avec les annotations Hibernate :
    - `@Entity`, `@Id`, `@OneToMany`, `@ManyToOne`, `@JoinColumn`, etc.

2. Configurez Hibernate pour générer automatiquement les tables.

3. Vérifiez que les tables et relations suivantes sont créées :
    - `auteur`
    - `livre` avec deux clés étrangères `auteur_id` et `maison_id`
    - `maison_edition`

4. Écrivez un programme de test qui :
    - insère 2 auteurs, 2 maisons d’édition et 3 livres associés,
    - affiche la liste des livres avec leur auteur et leur maison d’édition.

---

## Livrables attendus
- Code Java des entités annotées.
- Fichier de configuration Hibernate.
- Class de test Java qui insère et affiche les données.
