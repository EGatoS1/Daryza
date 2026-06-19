# Daryza - Sistema de Inventario

## Instrucciones de instalación y ejecución

### Requisitos previos

- **Java 17 (JDK)**
- **Maven** (o usar el wrapper incluido `mvnw` / `mvnw.cmd`, no es necesario instalarlo aparte)
- **Node.js** (v18 o superior) y **npm**
- **Angular CLI 18** (`npm install -g @angular/cli`)
- **Oracle Database XE** corriendo en local (puerto `1521`, SID `XE`)

### 1. Clonar el repositorio

```bash
git clone <url-del-repositorio>
cd Daryza
```

### 2. Backend (`inventario_back`)

1. Ingresar a la carpeta del backend:
   ```bash
   cd inventario_back
   ```
2. Configurar la conexión a la base de datos en `src/main/resources/application.properties` (usuario, contraseña y URL), según tu instancia local de Oracle XE.
3. Levantar la aplicación con el wrapper de Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
   En Windows (PowerShell o CMD):
   ```bash
   mvnw.cmd spring-boot:run
   ```
4. El backend quedará disponible en `http://localhost:8080`.

### 3. Frontend (`inventario_front`)

1. Ingresar a la carpeta del frontend:
   ```bash
   cd inventario_front
   ```
2. Instalar las dependencias:
   ```bash
   npm install
   ```
3. Verificar que la URL del backend en `src/app/Settings/appsettings.ts` apunte a `http://localhost:8080/`.
4. Levantar el servidor de desarrollo:
   ```bash
   ng serve
   ```
5. Abrir el navegador en `http://localhost:4200`.

### 4. Orden recomendado de ejecución

1. Iniciar la base de datos Oracle XE.
2. Levantar el backend (`inventario_back`) → `mvnw spring-boot:run` (o `./mvnw spring-boot:run` en Linux/Mac).
3. Levantar el frontend (`inventario_front`) → `ng serve`.

| Componente | Carpeta | Comando de alzamiento |
|---|---|---|
| Base de datos | — | Servicio de Oracle XE iniciado |
| Backend | `inventario_back` | `mvnw spring-boot:run` |
| Frontend | `inventario_front` | `ng serve` |
