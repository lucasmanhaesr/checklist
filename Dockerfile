# Etapa 1: Build da aplicação usando imagem com Gradle
FROM gradle:8.13-jdk21 AS build
WORKDIR /app

# Copia os arquivos necessários para o build
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
COPY src ./src

# Faz o build da aplicação
RUN gradle build --no-daemon

# Etapa 2: Imagem final para execução da aplicação
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório de trabalho na imagem final
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=build /app/build/libs/*.jar app.jar

# Expõe a porta padrão do Spring Boot (ajuste conforme sua aplicação)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
