# Level-UP Gamer 🎮

Tienda online de productos gamer: consolas, PC, accesorios, sillas, juegos de mesa y ropa. Tiene catálogo, carrito de compras, registro e inicio de sesión de usuarios, y un panel de administración para gestionar productos, categorías y usuarios.

Partió como proyecto del ramo **Fullstack II** en DuocUC y lo he seguido mejorando por mi cuenta.

## Evolución del proyecto

El proyecto pasó por varias etapas:

1. **HTML, CSS y JavaScript.** La primera versión era un sitio estático con páginas separadas (inicio, login, registro, perfil, comunidad, nosotros) y la lógica del carrito, el buscador, los filtros por categoría y las reseñas hecha en JavaScript puro, guardando los datos en el navegador. Esa versión quedó guardada en `Frontend_levelup-main/Template`.
2. **Migración a React.** Pasé el sitio a React con TypeScript y Vite. Cada página se convirtió en componentes reutilizables (navbar, footer, carrusel, tarjetas de producto) y la navegación quedó con React Router.
3. **Backend con Spring Boot.** Agregué una API REST en Java con base de datos MySQL. Los productos, usuarios y el carrito dejaron de estar en el navegador y pasaron a la base de datos, con login mediante JWT y contraseñas encriptadas con BCrypt.
4. **Docker.** Después de un tiempo retomé el proyecto y lo integré con Docker, para levantar la base de datos sin instalar MySQL en el computador.

## Tecnologías

**Frontend**
- React 19 + TypeScript
- Vite
- React Router
- Bootstrap / React Bootstrap
- Axios
- jwt-decode

**Backend**
- Java 21
- Spring Boot 4 (Web, Data JPA)
- MySQL 8
- JWT (jjwt) y BCrypt
- Lombok
- Swagger / OpenAPI (springdoc)
- Datafaker para los datos de prueba

**Herramientas**
- Docker y Docker Compose
- Maven
- Git y GitHub

## Funcionalidades

**Usuarios**
- Catálogo de productos con filtros por categoría
- Detalle de cada producto
- Carrito de compras: agregar, cambiar cantidades, eliminar y vaciar
- Registro con validaciones (correo, contraseña segura y mayoría de edad)
- Inicio de sesión y perfil
- Secciones de Comunidad y Nosotros

**Administrador**
- Panel de inicio del administrador
- CRUD de productos
- Gestión de categorías
- Listado y eliminación de usuarios
- Rutas protegidas según el rol del usuario

## Estructura

```
Level-UP/
├── Backend_levelup-main/     API REST con Spring Boot
│   └── src/main/java/cl/duoc/levelup/
│       ├── controller/       Endpoints
│       ├── service/          Lógica de negocio
│       ├── repository/       Acceso a datos (JPA)
│       ├── model/            Entidades
│       ├── dto/              Objetos de entrada y salida
│       ├── security/         Generación de JWT
│       └── DataLoader.java   Carga de datos iniciales
├── Frontend_levelup-main/    Aplicación React
│   ├── src/
│   │   ├── api/              Llamadas a la API
│   │   ├── components/       Componentes reutilizables
│   │   ├── pages/            Páginas
│   │   ├── interfaces/       Tipos de TypeScript
│   │   └── assets/           Estilos
│   └── Template/             Versión original en HTML, CSS y JS
└── docker-compose.yml        Base de datos MySQL
```

## Cómo ejecutarlo

### Requisitos
- Docker Desktop
- Java 21
- Node.js 20 o superior

### 1. Base de datos

Desde la carpeta raíz del proyecto:

```bash
docker compose up -d
```

Esto levanta MySQL en el puerto `3306` con la base `levelup` ya creada (usuario `root`, contraseña `root`).

### 2. Backend

```bash
cd Backend_levelup-main
./mvnw spring-boot:run        # en Windows: mvnw.cmd spring-boot:run
```

También se puede abrir la carpeta en IntelliJ IDEA y ejecutar `LevelupApplication`.

La API queda en `http://localhost:8080`. La primera vez se crean las tablas y se cargan las categorías, los productos y un usuario administrador.

La documentación de la API está en Swagger:
`http://localhost:8080/doc/swagger-ui.html`

### 3. Frontend

```bash
cd Frontend_levelup-main
npm install
npm run dev
```

La aplicación queda en `http://localhost:5173`.

### Usuario de prueba

| Rol   | Correo          | Contraseña |
|-------|-----------------|------------|
| Admin | admin@gmail.com | admin      |

También puedes crear un usuario normal desde la página de registro.

## Endpoints principales

| Método | Ruta                                  | Descripción                  |
|--------|---------------------------------------|------------------------------|
| GET    | `/api/v1/productos`                   | Lista de productos           |
| GET    | `/api/v1/productos/{id}`              | Detalle de un producto       |
| POST   | `/api/v1/productos`                   | Crear producto               |
| PUT    | `/api/v1/productos/{id}`              | Editar producto              |
| DELETE | `/api/v1/productos/{id}`              | Eliminar producto            |
| GET    | `/api/v1/categorias`                  | Lista de categorías          |
| POST   | `/api/v1/categorias`                  | Crear categoría              |
| POST   | `/api/v1/usuarios`                    | Registrar usuario            |
| POST   | `/api/v1/usuarios/login`              | Iniciar sesión               |
| GET    | `/api/v1/carrito/usuario/{usuarioId}` | Carrito de un usuario        |
| POST   | `/api/v1/carrito`                     | Agregar producto al carrito  |
| DELETE | `/api/v1/carrito/usuario/{usuarioId}` | Vaciar carrito               |

La lista completa está en Swagger.

## Próximas mejoras

- Validar el token JWT y los roles también en el backend, con Spring Security
- Proceso de compra con pedidos e historial en el perfil
- Control de stock
- Buscador y paginación en el catálogo
- Tests en backend y frontend
- Levantar el proyecto completo (base de datos, backend y frontend) con Docker Compose
- Publicar una demo en línea

## Autor

**Francisco García**
Estudiante de Ingeniería en Informática, DuocUC
