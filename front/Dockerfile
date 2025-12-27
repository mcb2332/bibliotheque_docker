FROM node:20-bullseye

# Dossier de travail à l'intérieur du conteneur
WORKDIR /app

# Copie des fichiers package.json et package-lock.json => pour installation des dép
COPY package*.json ./

# Installation des dépendances du projet
# pourquoi npm ci et pas npm install ?
# => installation propre et respecte exactement le package-lock.json
RUN npm ci

# Copie de tout le reste du projet (code source Angular)
COPY . .

# Exposition du port 4200 => Angular
EXPOSE 4200

# Lance le serveur de développement Angular
CMD ["npm", "start", "--", "--host", "0.0.0.0", "--port", "4200"]
