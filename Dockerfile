# Usar una imagen de OpenJDK
FROM openjdk:17-jdk-slim

# Argumento para el archivo JAR
ARG JAR_FILE=target/*.jar

# Copiar el archivo JAR a la imagen
COPY ${JAR_FILE} app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
