# Proyecto – Examen Técnico CRUD HXWXM

Proyecto Spring Boot para la gestión de **Usuarios y Roles** con una relación **Many-to-Many**, expuesto mediante una **API REST** y utilizando una base de datos **H2 en memoria** para pruebas y desarrollo.

---

## 📌 Información general

- **Autor:** Ulises Sánchez Muñoz  
- **Contacto:** wulisesbusiness@gmail.com  
- **Fecha:** Diciembre 2025 
- **Tipo:** Examen técnico / Proyecto Profesional

---

## 📝 Descripción

Este proyecto implementa un **CRUD completo** para las entidades **Usuario** y **Rol**, cumpliendo con los requerimientos de un examen técnico.  

Cada usuario puede tener múltiples roles y cada rol puede estar asociado a múltiples usuarios, utilizando una relación **Many-to-Many** gestionada con **Spring Data JPA**.

La aplicación expone una **API REST** que puede ser consumida y probada mediante **Postman**, y utiliza una base de datos **H2 en memoria** para facilitar pruebas rápidas sin configuración adicional.

---

## 🛠 Tecnologías y dependencias

- Java 17  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- H2 Database (in-memory)  
- Maven  
- Spring Web  
- Jackson (serialización JSON)  

> 🔒 Spring Security no está habilitado para simplificar las pruebas de los endpoints.

---

## 🧱 Arquitectura y diseño

El proyecto sigue una arquitectura en capas:

- **Controller**  
  Exposición de endpoints REST para Usuarios y Roles.

- **Service**  
  Lógica de negocio y manejo de relaciones entre entidades.

- **Repository**  
  Interfaces JPA para acceso a datos.

- **Model**  
  Entidades JPA (`Usuario`, `Rol`) con relación **Many-to-Many**.

- **Base de datos**  
  H2 en memoria con las siguientes tablas:
  - `TUSUARIO`
  - `TROLE`
  - `USUARIO_ROL` (tabla intermedia)

### Relación principal

- Un **Usuario** puede tener múltiples **Roles**  
- Un **Rol** puede pertenecer a múltiples **Usuarios**

---

## 🔗 Endpoints disponibles

### 👤 Usuarios

- `GET /usuarios` → Obtiene todos los usuarios con sus roles  
- `GET /usuarios/{id}` → Obtiene un usuario por ID  
- `GET /usuarios/nombre/{nombre}` → Busca usuarios por nombre  
- `POST /usuarios` → Crea un usuario con roles  
- `PUT /usuarios/{id}` → Actualiza un usuario y sus roles  
- `DELETE /usuarios/{id}` → Elimina un usuario  

### 🧩 Roles

- `GET /roles` → Obtiene todos los roles  
- `GET /roles/{id}` → Obtiene un rol por ID  
- `GET /roles/nombre/{nombre}` → Busca roles por nombre  
- `POST /roles` → Crea un rol  
- `PUT /roles/{id}` → Actualiza un rol  
- `DELETE /roles/{id}` → Elimina un rol  

---

## 📦 Ejemplos de uso

### Crear usuario con roles  
**POST `/usuarios`**

```json
{
  "nombre": "Haru",
  "aPaterno": "Sánchez",
  "aMaterno": "Okumura",
  "roles": [1, 1]
}
