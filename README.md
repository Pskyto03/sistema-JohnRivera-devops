# Sistema educativo microservicios - John Alexander Rivera Rivera

markdown

# Gestión de Productos Reactivo

Proyecto básico para aprender **Spring Boot**, **Spring Security**, **programación reactiva con WebFlux**, **internacionalización (i18n)** en 3 idiomas (español, inglés, francés), y conexión con **MongoDB** usando operaciones CRUD.


## Tecnologías Usadas

-	Java 17
-	Spring Boot 3.x
-	Spring WebFlux (reactivo)
-	Spring Security
-	Spring Data Reactive MongoDB
-	Internacionalización (i18n)
-	Postman (para pruebas)
-	Lombok
-   Docker
-   MongoDB
-   JWT

---
## Internacionalización Endpoint de prueba:
GET /api/usuarios
yaml

---
## Seguridad
POST /usuarios/auth/login
-	Autenticación JWT
-	Usuario: `jarr1`
-	Contraseña: `Password123`

---
 
## Endpoints CRUD (Protegidos)

Método	Endpoint	Descripción
GET	`/api/productos`	Lista todos los productos
POST	`/api/productos/{id}`	Crear un nuevo producto
GET	`/api/productos/{id}`	Buscar producto por ID
PUT	`/api/productos/{id}`	Actualizar producto por ID
DELETE	`/api/productos/{id}`	Eliminar producto por ID

---

## Pruebas con Postman

1.	Usa autenticación básica con el usuario y clave.
2.	Prueba el CRUD y el endpoint `/mensaje?lang=fr`.

---

## Requisitos para ejecutar

-	Java 17
-	Maven 3.8+
-   Docker
---

## Cómo correr el proyecto

```bash
# Clonar el repositorio
git clone https://github.com/tuusuario/gestion-productos-reactivo.git

# Entrar al proyecto
cd gestion-productos-reactivo

# Ejecutar el proyecto (maven)
./mvnw spring-boot:run

# Ejecutar el proyecto (Docker)
 docker-compose up -d





pgsql

---

## 2. Archivo `.gitignore`

```gitignore
# Compiled class file
*.class
# Maven target/
!.mvn/wrapper/maven-wrapper.jar
**/target/

# Logs
*.log

# IntelliJ IDEA
.idea/
*.iml

# Eclipse
.project
.classpath
.c9/
.settings/
# VS Code
.vscode/
# OS
.DS_Store Thumbs.db

## Ejecución de Pruebas

### Pruebas Unitarias
Para ejecutar solo las pruebas unitarias:
```
./mvnw test -Dtest=ProductoServiceTest

# Pruebas de ejcucion local

![img.png](img.png)
![img_1.png](img_1.png)
![img_2.png](img_2.png)
![img_3.png](img_3.png)

