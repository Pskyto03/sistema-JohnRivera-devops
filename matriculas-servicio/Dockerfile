# Usar una imagen base de OpenJDK para ejecutar Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el archivo JAR del microservicio
COPY target/matriculas-servicio-0.0.1-SNAPSHOT.jar matriculas-servicio.jar

# Exponer el puerto en el que se ejecutará el microservicio
EXPOSE 8083

# Comando para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "matriculas-servicio.jar"]
