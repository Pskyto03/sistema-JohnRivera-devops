# Usar una imagen base de OpenJDK para ejecutar Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR de Eureka Server al contenedor
COPY target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar

# Exponer el puerto de Eureka Server (por defecto, Eureka usa el puerto 8761)
EXPOSE 8761

# Comando para ejecutar el Eureka Server
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
