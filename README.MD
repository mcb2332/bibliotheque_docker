# Projet Bibliothèque

Ce projet est une application de gestion d'une bibliothèque permettant de gérer des **maisons d’édition**, des **auteurs** et des **livres**. Le frontend et le backend communiquent via **API REST**.

---

## Technologies utilisées

- **Backend :**
    - Java 21
    - Spring Boot
    - Spring Data JPA
    - Hibernate
    - MySQL
- **Frontend :**
    - Angular
- **Communication :**
    - REST API
- **Containerisation :**
    - Docker
    - Docker Compose

---

## Fonctionnalités

L'application permet de :

- **Maisons d’édition :**
    - Ajouter une maison d’édition
    - Voir la liste des maisons d’édition
- **Auteurs :**
    - Ajouter un auteur
    - Voir la liste des auteurs
- **Livres :**
    - Ajouter un livre en sélectionnant un ou plusieurs auteurs existants et une maison d’édition existante
    - Voir la liste des livres avec leurs auteurs et maison d’édition associée

---

## Architecture

L'application suit une architecture **frontend / backend / base de données** :

1. **Frontend (Angular) :**
    - Interface utilisateur pour interagir avec les fonctionnalités
    - Appelle le backend via REST API

2. **Backend (Spring Boot) :**
    - Expose les endpoints REST
    - Gère la logique métier et la persistance via Spring Data JPA / Hibernate
    - Connecte à la base de données MySQL

3. **Base de données (MySQL) :**
    - Stocke les données des livres, auteurs et maisons d’édition
    - Connectée au backend via JPA/Hibernate

---

## Docker

Le projet utilise **Docker Compose** pour orchestrer les conteneurs suivants :

- Frontend Angular
- Backend Spring Boot
- Base de données MySQL

### Environnement de Développement (DEV)


- Logs détaillés pour le debugging
- Base de données MySQL préremplie dédiée au développement
- Variables d'environnement définies dans `.env.dev`

### Environnement de Production (PROD)

- Conteneurs immuables
- Logs limités pour la production
- Base de données MySQL persistante sans données de départ
- Variables d'environnement définies dans `.env.prod`

---

## Résumé DEV vs PROD

| Fonctionnalité                       | Dev | Prod |
|--------------------------------------| --- |------|
| Logs détaillés                       | Oui | Non  |
| Base de données préremplie           | Oui | Non  |
| Variables d’environnement | Oui | Oui  |

---

## Instructions de lancement

1. **Cloner le projet :**
```bash
git clone <URL_DU_REPO>
cd <NOM_DU_PROJET>
