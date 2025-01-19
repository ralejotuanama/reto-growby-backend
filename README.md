Biblioteca Backend
Este es el backend de un sistema de gestión de biblioteca desarrollado en Java usando Spring Boot. Proporciona una API RESTful para la gestión de libros, autores y préstamos.

Características
Gestión de libros, autores y préstamos con operaciones CRUD.
Consulta de préstamos asociados a libros específicos.
Validación de disponibilidad de libros.
Paginación para listar entidades.
Integración con bases de datos H2 para pruebas locales y Oracle para producción.
Documentación interactiva de la API con Swagger.
Requisitos Previos
Java 17 o superior
Maven 3.8.1 o superior
Docker (para Oracle Database)
Postman o cliente HTTP para pruebas.
Instalación y Ejecución
1. Clonar el Repositorio
   bash
   Copiar
   git clone https://github.com/ralejotuanama/reto-growby-backend.git
   
2. Configurar la Base de Datos
   Para H2 (local)
   H2 es una base de datos en memoria para pruebas. Configuración predeterminada en application.properties:

properties
Copiar
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
Accede a la consola H2 en http://localhost:8080/h2-console.

Para Oracle (producción)
Si usas Oracle, configura application-oracle.properties:

properties
Copiar
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/xe
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
Ejecuta Oracle en Docker:

bash
Copiar
docker run -d --name oracle-db -p 1521:1521 -e ORACLE_PASSWORD=oracle_password gvenzl/oracle-xe:latest
3. Ejecutar la Aplicación
   Compilar el proyecto:

bash
Copiar
mvn clean install
Ejecutar la aplicación:

bash
Copiar
mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.




Estructura del Proyecto
bash
Copiar
src/
├── main/
│   ├── java/com/growby/reto/
│   │ 
│   │   ├── controllers/  # Controladores REST
│   │   ├── models/       # Entidades JPA
│   │   ├── repositories/ # Interfaces JPA
│   │   ├── services/     # Lógica de negocio
│   │   └── RetoApplication.java # Clase principal
│   └── resources/
│       ├── application.properties       # Configuración por defecto
│       ├── application-oracle.properties # Configuración para Oracle
│       └── schema.sql                   # Opcional: Script SQL
Endpoints Principales
Libros
GET /api/libros - Listar libros (con paginación). --> http://localhost:8080/api/libros?page=0&size=5
GET /api/libros/todos - Listar libros (sin paginación).
POST /api/libros - Crear un libro.
POST /api/libros - Actualizar un libro.
DELETE /api/libros/{id} - Eliminar un libro.
Autores
GET /api/autores - Listar autores.
POST /api/autores - Crear un autor.
POST /api/autores - Actualizar un autor.
DELETE /api/autores/{id} - Eliminar un autor.
Préstamos
GET /api/prestamos - Listar préstamos.
POST /api/prestamos - Crear un préstamo.
GET /api/prestamos/libro/{id}/prestamos - Listar préstamos de un libro específico.
Contribuir

Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
Realiza tus cambios y haz commit (git commit -am 'Agregar nueva funcionalidad').
Sube tus cambios (git push origin feature/nueva-funcionalidad).
Abre un Pull Request.
Autor
Ronald Alejo Tuanama