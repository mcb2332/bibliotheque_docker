# Bibliothèque - Docker Setup

Ce projet est une application de bibliothèque composée de trois services : **backend Java/Spring Boot**, **frontend Angular**, et **base de données MySQL**

---

## 📂 Structure du projet

- **MySQL** : base de données
- **Backend** : API REST Spring Boot
- **Frontend** : application Angular

---

## ⚙️ Programme utilisé

- Docker ≥ 20.10  
- Docker Compose ≥ 2.0  
- Node.js   
- Maven 

---

## 🐳 Docker Compose

Les services sont définis dans `docker-compose.yml`.  
Deux fichiers `.env` permettent de différencier les environnements :

- `.env.dev` : développement
- `.env.prod` : production

---

## 📦 Explication des Dockerfile

### Backend (Java / Spring Boot)

Le Dockerfile backend utilisé :

```dockerfile
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests -X

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
```

### FrontEnd (Angular)

Le Dockerfile frontend utilisé :

```dockerfile
FROM node:20-bullseye
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
EXPOSE 4200
CMD ["npm", "start", "--", "--host", "0.0.0.0", "--port", "4200"]
```

Explication dans le code dockerfile détailler

---


### 🏗️ Commandes de lancement

#### Développement
```bash
docker compose --env-file .env.dev up --build
```

#### Production
```bash
docker compose --env-file .env.dev up --build
```
