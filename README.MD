# Docker

Ce projet utilise **Docker Compose** afin d’orchestrer plusieurs conteneurs représentant différents microservices.

L’objectif est de séparer clairement le frontend, le backend et la base de données, et de distinguer les environnements **développement** et **production**.

---

# Environnement de Développement (DEV)

En développement, l'objectif est de permettre une itération rapide, des logs détaillés et une modification directe du code via des volumes montés.

## Frontend (Angular)

- Le frontend est développé avec **Angular**.
- Le code source est monté directement depuis la machine locale dans le conteneur grâce à un volume.
- Toute modification locale est immédiatement visible sans reconstruire l’image.
- Les logs sont complets, destinés au debugging.

## Backend (Spring Boot)

- Le backend utilise **Java** avec **Spring Boot**.
- Comme pour le frontend, le code est monté depuis la machine locale afin de permettre un redémarrage rapide et des mises à jour à chaud selon la configuration.
- Les logs sont plus verbeux pour faciliter le développement.
- Le conteneur utilise une configuration spécifique à l’environnement de développement (profil `dev`).

## Base de Données (MySQL - DEV)

- En développement, on utilise une **base de données distincte** de celle utilisée en production.
- Les volumes peuvent être réinitialisés facilement.
- Les credentials et paramètres DB sont définis dans un fichier d'environnement dédié (ex. `.env.dev`).
- Les données ne sont pas critiques et peuvent être régénérées.

## Variables d'environnement (DEV)

- Les variables d'environnement sont définies dans un fichier spécifique (ex. `.env.dev`).
- Ces variables sont injectées automatiquement par Docker Compose.
- Elles peuvent être modifiées à chaud pour ajuster rapidement la configuration du système.

---

# Environnement de Production (PROD)

En production, l’objectif est la stabilité, la sécurité et l’isolation stricte.

Aucun code source n’est monté depuis la machine hôte : les conteneurs sont immuables.

## Frontend (Angular)

- Le frontend est compilé et déployé dans une image Docker autonome.
- Aucun volume n’est monté depuis l’extérieur.
- Les fichiers du frontend ne sont pas modifiables une fois l’image créée.

## Backend (Spring Boot)

- Le backend est packagé dans un jar final puis intégré à une image Docker prête à l’emploi.
- Le profil actif est `prod`.
- Les logs sont limités pour éviter les surcharges et respecter les bonnes pratiques de production.

## Base de Données (MySQL - PROD)

- La base de données de production est isolée et différente de celle utilisée en développement.
- Les données sont persistées via des volumes dédiés.
- Les accès sont sécurisés via des variables d’environnement propres à la production (ex. `.env.prod`).

## Variables d'environnement (PROD)

- Les variables d'environnement sont définies dans un fichier spécifique (ex. `.env.prod`).
- Elles ne sont pas modifiables à chaud sur les conteneurs en production.
- Les valeurs sensibles sont protégées et ne doivent pas être versionnées.

---

# Résumé DEV vs PROD

| Fonctionnalité | Dev | Prod |
| --- | --- | --- |
| Code modifiable via volumes | Oui | Non |
| Logs détaillés | Oui | Non |
| DB dédiée | Oui | Oui |
| Variables d’env modifiables à chaud | Oui | Non |
| Images immuables | Non | Oui |
