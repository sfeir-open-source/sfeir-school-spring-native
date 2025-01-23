# Build stage
FROM ghcr.io/graalvm/native-image-community:21 AS builder
WORKDIR /app
COPY . /app
RUN ./mvnw -Pnative native:compile

# Runtime stage
FROM ubuntu:22.04
WORKDIR /app
# Copie l'exécutable natif depuis l'étape de build
COPY --from=builder /app/target/springnative-lab /app/application

# Expose le port (ajustez selon votre application)
EXPOSE 8080

# Démarrage de l'application
ENTRYPOINT ["/app/application"]
