# Bibliothèque - Docker Setup

Ce projet est une application de bibliothèque composée de trois services : **backend Java/Spring Boot**, **frontend Angular**, et **base de données MySQL**, orchestrés via **Docker Compose**.

---

## 📂 Structure du projet

- **MySQL** : base de données
- **Backend** : API REST Spring Boot
- **Frontend** : application Angular

---

## ⚙️ Programme utilisé

- Docker ≥ 20.10  
- Docker Compose ≥ 2.0  
- Node.js (pour tests locaux si besoin)  
- Maven (pour tests locaux si besoin)

---

## 🐳 Docker Compose

Les services sont définis dans `docker-compose.yml`.  
Deux fichiers `.env` permettent de différencier les environnements :

- `.env.dev` : développement
- `.env.prod` : production

---

### 🏗️ Commandes de lancement

#### Développement
```bash
docker compose --env-file .env.dev up --build

et 

docker compose --env-file .env.dev up --build
