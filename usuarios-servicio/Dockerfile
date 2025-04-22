# Usar una imagen base de OpenJDK para ejecutar Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el archivo JAR del microservicio
COPY target/usuarios-0.0.1-SNAPSHOT.jar usuarios.jar

# Exponer el puerto en el que se ejecutará el microservicio
EXPOSE 8081

# Comando para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "usuarios.jar"]
