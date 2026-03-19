# ms-BTG-Pactual

Microservicio desarrollado en Spring Boot para la gestión de fondos de inversión, permitiendo suscripción, cancelación y consulta de transacciones.

🚀 Tecnologías

Java 17

Spring Boot 3

MongoDB

Docker & Docker Compose

Gradle

---

🐳 Ejecución con Docker

Levantar todos los servicios:

docker-compose up -d --build

Servicios disponibles:

API: http://localhost:8085

Mongo Express: http://localhost:8081

Credenciales Mongo Express:

usuario: admin
password: admin

---
Colección de Fondos

<img width="1454" height="937" alt="Captura de pantalla 2026-03-18 094816" src="https://github.com/user-attachments/assets/5ab91902-ed17-415e-a27a-69e6e0f19e90" />

---
Endpoints
📌 Suscribir a fondo

POST /fondos/suscribir

{
  "clienteId": "c1",
  "fondoId": "1",
  "monto": 100000
}

<img width="1305" height="712" alt="Captura de pantalla 2026-03-18 093819" src="https://github.com/user-attachments/assets/b543ccd5-fd4a-4b75-abc4-be98065456e1" />


validación de monto minimo requerido por el Fondo

<img width="1275" height="654" alt="Captura de pantalla 2026-03-18 102104" src="https://github.com/user-attachments/assets/94275af6-93e2-466f-8545-11e7661a0677" />

📌 Cancelar suscripción

POST /fondos/cancelar

{
  "clienteId": "c1",
  "fondoId": "1"
}

<img width="1265" height="707" alt="Captura de pantalla 2026-03-18 094055" src="https://github.com/user-attachments/assets/1829ae09-b305-4ea4-9ad4-08967c3b1d20" />

📌 Historial de transacciones

GET /transacciones/{clienteId}

Ejemplo:

GET /transacciones/c1

<img width="1286" height="714" alt="Captura de pantalla 2026-03-18 094253" src="https://github.com/user-attachments/assets/61c08418-8d8d-4a87-9081-30d4e52c2ae7" />
