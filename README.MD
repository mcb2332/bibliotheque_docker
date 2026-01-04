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
- **Frontend Angular**  
  Image disponible sur Docker Hub : `alexlbb/bibliotheque-frontend`
- **Backend Spring Boot**  
  Image disponible sur Docker Hub : `alexlbb/bibliotheque-backend`
- **Base de données MySQL**  
  Image officielle : `mysql`

Les images du **frontend** et du **backend** sont stockées dans des **repositories séparés sur Docker Hub**.  
La commande `docker compose` récupère directement ces images depuis Docker Hub lors du lancement du projet.

---

### Environnement de Développement (DEV)
- Logs détaillés pour le debugging
- Base de données MySQL préremplie avec des données de test
- Variables d'environnement définies dans `.env.dev`

**Lancement en DEV :**
```bash
docker compose -p nom_de_dev --env-file .env.dev up
```
> **Note :** Remplacez `nom_de_dev` par le nom de votre projet Docker Compose pour l'environnement de développement.

### Environnement de Production (PROD)
- Logs minimaux pour de meilleures performances
- Base de données MySQL persistante (vide au premier lancement)
- Variables d'environnement définies dans `.env.prod`

**Lancement en PROD :**
```bash
docker compose -p nom_de_prod --env-file .env.prod up
```
> **Note :** Remplacez `nom_de_prod` par le nom de votre projet Docker Compose pour l'environnement de production.

---

## Résumé DEV vs PROD
| Fonctionnalité                | DEV | PROD |
|-------------------------------|-----|------|
| Logs détaillés                | ✓   | ✗    |
| Base de données préremplie    | ✓   | ✗    |
| Variables d'environnement     | ✓   | ✓    |

---

## Instructions de lancement

1. **Cloner le projet :**
```bash
   git clone <URL_DU_REPO>
   cd <NOM_DU_PROJET>
```

2. **Choisir l'environnement :**
   - Pour le développement, utilisez la commande DEV ci-dessus
   - Pour la production, utilisez la commande PROD ci-dessus

3. **Arrêter les conteneurs :**
```bash
   docker compose -p <nom_du_projet> down
```
