<!-- .slide: class="with-code" -->
# Déployer l'application avec Docker

```Dockerfile
# Maven

# Build stage
FROM ghcr.io/graalvm/native-image-community:21 AS builder
WORKDIR /app
COPY . /app
RUN ./mvnw -Pnative native:compile

# Runtime stage
FROM ubuntu:22.04
WORKDIR /app
# Copie l'exécutable natif depuis l'étape de build
COPY --from=builder /app/target/my-app-name /app/application

# Expose le port
EXPOSE 8080

# Démarrage de l'application
ENTRYPOINT ["/app/application"]
```
##==##

<!-- .slide: class="with-code" -->
# Déployer l'application avec Docker

```Dockerfile
# Gradle

# Build stage
FROM ghcr.io/graalvm/native-image-community:21 AS builder
WORKDIR /app
COPY . /app
RUN ./gradlew nativeCompile

# Runtime stage
FROM ubuntu:22.04
WORKDIR /app
# Copie l'exécutable natif depuis l'étape de build
COPY --from=builder /app/build/native/nativeCompile/my-app-name /app/application

# Expose le port
EXPOSE 8080

# Démarrage de l'application
ENTRYPOINT ["/app/application"]
```
##==##

<!-- .slide: class="with-code" -->

# Déployer l'application avec Docker

```shell

# Build de l'image
docker build -t myapp-native .

# Exécution du conteneur
docker run -p 8080:8080 myapp-native
  
```
