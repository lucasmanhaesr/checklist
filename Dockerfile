# Imagem base com Java
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR do host para o container
COPY build/libs/checklist-0.0.1.jar app.jar

# Expõe a porta usada pela aplicação (altere conforme necessário)
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
