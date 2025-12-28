# Image Maven avec Java 21 (=> compile le projet Spring Boot)
FROM maven:3.9-eclipse-temurin-21 AS build

# Dossier de travail à l'intérieur du conteneur
WORKDIR /app

# Copie du fichier pom.xml
# Il contient les dépendances et la configuration Maven
COPY pom.xml .

# Copie du dossier src qui contient le code source Java
COPY src ./src

# Compilation du projet avec Maven (log détaillé)
RUN mvn clean package -DskipTests -X


# exécute seulement l'app => légère et contient uniquement JRE
# Contient seulement le JRE (Java Runtime Environment)
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copie du fichier .jar généré dans l'étape de build récupére le fichier depuis la première image
COPY --from=build /app/target/*.jar app.jar

# Exposition du port 8080 => Spring Boot
EXPOSE 8080

# Lance l'application Java
CMD ["java", "-jar", "app.jar"]
