# 🎯 Patrón MVC - Estructura del Proyecto

Este proyecto implementa el patrón de arquitectura **MVC** (Modelo - Vista - Controlador) para lograr una separación clara de responsabilidades, mejor mantenimiento y escalabilidad del sistema.

---

## 🗂️ Estructura General

```

📁 controller/
📁 model/
📁 service/
📁 view/
📁 resources/sql/

```

---

## 🧩 ¿Qué es el patrón MVC?

El patrón **MVC** divide una aplicación en tres componentes principales:

| Componente   | Descripción                                                                 |
|--------------|-----------------------------------------------------------------------------|
| 🎮 Controlador (`controller/`) | Maneja las solicitudes del usuario y coordina las acciones entre el modelo y la vista. |
| 🧠 Modelo (`model/`)        | Representa la lógica de datos del sistema. Se comunica con la base de datos.             |
| 👁️ Vista (`view/`)         | Interfaz de usuario. Presenta los datos que recibe del controlador.                     |

---

## 📁 Descripción de Carpetas

### 📂 `controller/`  
📌 *Responsabilidad:*  
Gestiona las peticiones del usuario y coordina las acciones del modelo y la vista.  
🛠️ *Estado:* Agregar y Editar (actualizado la semana pasada)

---

### 📂 `model/`  
📌 *Responsabilidad:*  
Contiene las clases que representan la estructura de los datos.  
📊 *Ejemplo:* Clases que mapean las tablas de la base de datos.  
🛠️ *Estado:* Agregar y Editar (actualizado la semana pasada)

---

### 📂 `service/`  
📌 *Responsabilidad:*  
Encapsula la lógica del negocio. Actúa como puente entre el controlador y el modelo.  
♻️ *Ventaja:* Permite reutilizar reglas de negocio sin duplicar código.  
🛠️ *Estado:* Agregar y Editar (actualizado la semana pasada)

---

### 📂 `view/`  
📌 *Responsabilidad:*  
Muestra los datos al usuario de forma amigable. Puede contener archivos HTML, CSS, JS, etc.  
🖥️ *Enlace visual entre el usuario y la aplicación.*  
🛠️ *Estado:* Agregar y Editar (actualizado la semana pasada)

---

### 📂 `resources/sql/`  
📌 *Responsabilidad:*  
Contiene los scripts SQL necesarios para la creación y mantenimiento de la base de datos.  
🗄️ *Incluye:* Scripts de inserción, migración y consultas.  
🛠️ *Estado:* Agregar y Editar (actualizado la semana pasada)

---

## 📝 Últimas modificaciones

📅 **Semana pasada**  
Todas las carpetas mencionadas fueron actualizadas con funciones de **Agregar** y **Editar** para mejorar la funcionalidad del sistema.

---

## 🚀 Ventajas de usar MVC

- 🔄 Separación clara de responsabilidades
- 🔧 Facilita el mantenimiento y pruebas
- 📦 Favorece la reutilización de componentes
- 🧪 Mejora la calidad del código y permite mayor escalabilidad

---

## ✅ Recomendaciones

- Mantén la lógica de negocio fuera del controlador.
- Usa servicios para centralizar reglas complejas.
- Actualiza los modelos si cambian las estructuras de datos.
- Reutiliza vistas para mantener una UI coherente.


---

## 👩‍💻 Autora

Desarrollado con 💙 por **Valery**  
🎓 *Monitora de Análisis de Sistemas Empresariales*  
Apasionada por la **arquitectura de software**, la **programación limpia** y la aplicación de **buenas prácticas** en el desarrollo de soluciones eficientes y sostenibles.

📚 Convencida de que el conocimiento no tiene límites, siempre en constante aprendizaje y con el firme propósito de mejorar cada línea de código escrita.

✨ *"El código bien hecho no solo funciona, también se entiende y se disfruta."*
