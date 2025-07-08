# NearMe – Proximity-Based Search Backend
**NearMe** is a Spring Boot backend application that enables proximity-based location search, similar to Google Maps. It accepts user location and query (title and tags), and returns the closest relevant places, sorted by distance using the Haversine formula.

---

## 🚀 Features

- Accepts user latitude and longitude
- Search places by title, tags, or both
- Calculates great-circle distance (Haversine formula)
- Returns paginated and sorted list of matching places

---

## 📦 Tech Stack

| Layer       | Technology                         |
|-------------|------------------------------------|
| Language    | Java 17+                           |
| Framework   | Spring Boot 3                      |

---

## 📁 Project Structure

```
src/main/java/com/nearme/
├── controller/         # REST endpoints
├── service/            # Business logic
├── dao/                # Data Access Abstraction
├── repository/         # Spring Data JPA
├── model/              # JPA Entities
├── dto/                # Request/Response Objects
├── util/               # Utility Classes (e.g. Distance Calculator)
└── exception/          # Global Exception Handler
```

---

## 📄 Sample API Request

### `POST /api/places/search`

**Request Body**:
```json
{
  "latitude": 12.9716,
  "longitude": 77.5946,
  "title": "cafe",
  "tags": ["coffee", "restaurant"],
  "page": 0,
  "size": 10
}
```

**Response**:
```json
{
  "content": [
    {
      "id": 1,
      "title": "Cafe Coffee Day",
      "latitude": 12.9721,
      "longitude": 77.5949,
      "tags": ["cafe", "coffee"],
      "distance": 0.13
    }
  ],
  "totalElements": 25,
  "totalPages": 3,
  "number": 0,
  "size": 10,
  "first": true,
  "last": false
}
```

---

## 🧮 Distance Calculation

Uses the **Haversine formula** in Java to compute accurate spherical distances between user and place locations.

```java
DistanceCalculator.calculate(lat1, lon1, lat2, lon2);
```

---

## ⚙️ Configuration

### `application.yml`
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:nearme-db;DB_CLOSE_DELAY=-1
    driver-class-name: org.h2.Driver
    username: sa
    password:
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## 🧪 Running Locally

### 🚀 Prerequisites:
- Java 17+
- Maven

### ▶️ Run the App

```bash
./mvnw spring-boot:run
```

Or import into IntelliJ/Eclipse and run `NearMeApplication.java`.

### 🔍 H2 Console
URL: `http://localhost:8080/h2-console`  
JDBC URL: `jdbc:h2:mem:nearme-db`  
Username: `sa`, Password: (leave blank)

---

## 🌐 API & Tool URLs

| Description                        | URL                                           |
|------------------------------------|-----------------------------------------------|
| ✅ Base URL                        | http://localhost:8090                         |
| 🚀 Search Places API (POST)        | http://localhost:8090/api/places/search       |
| 🔍 Natural Language Search (POST)* | http://localhost:8090/api/places/nl-search    |
| 🧪 H2 Database Console             | http://localhost:8090/h2-console              |
| 📘 Swagger UI                      | http://localhost:8090/swagger-ui.html         |
| 🧾 OpenAPI JSON (Swagger Spec)     | http://localhost:8090/v3/api-docs             |
| 📫 Postman Import (use above URL) | (Import Swagger JSON in Postman)              |

---

## ✅ Future Enhancements

- [ ] Add **R-Tree or PostGIS** support for true spatial indexing
- [ ] Enable **natural language queries** (e.g., “Bookstores Near Me”)

---

## ▶️ Getting Started Locally

Follow these steps to run the NearMe backend application on your local machine.

---

### 🔧 Prerequisites

Make sure you have the following installed:

- 🛠️ Java 17+
- 🧰 Maven 3.6+
- 💻 Any IDE (IntelliJ, VS Code, Eclipse) or terminal

---

### 🚀 Run Using Maven (CLI)

1. Clone the project:
   ```bash
   git clone https://github.com/your-username/NearMe.git
    cd NearMe
    ./mvnw spring-boot:run

---

### 💻 Run Using Your IDE (IntelliJ / Eclipse / VS Code)

Follow these steps to run the project from your favorite Java IDE:

1️⃣ **Open Project**
- Launch your IDE (e.g., IntelliJ, Eclipse, VS Code)
- Select: 📁 File → Open → Choose the cloned NearMe project folder
- Ensure it’s imported as a Maven project

2️⃣ **Build & Run**
- Navigate to: `src/main/java/com/nearme/NearMeApplication.java`
- Right-click → ▶️ Run `NearMeApplication`

3️⃣ **Access the Application**
- 🌐 App Running At: [http://localhost:8090](http://localhost:8090)

4️⃣ **Explore the In-Memory Database**
- 🗃️ H2 Console: [http://localhost:8090/h2-console](http://localhost:8090/h2-console)
- JDBC URL: `jdbc:h2:mem:nearme-db`
- Username: `sa`, Password: _(leave blank)_

5️⃣ **Test APIs Visually**
- 📘 Swagger UI: [http://localhost:8090/swagger-ui.html](http://localhost:8090/swagger-ui.html)
- Interactively test endpoints, see sample requests & responses

6️⃣ **Use Postman to Test APIs**
- 🔁 Use provided sample JSON to test `/api/places/search`
- 🔍 For Natural Language Search (if implemented):
    - Endpoint: `POST /api/places/nl-search`
    - Body:
      ```json
      { "query": "cafes within 2 km" }
      ```

7️⃣ **Need More Info?**
- 📑 Full API reference available in Swagger UI

---


## 👨‍💻 Author

Built with ❤️, ☕, and clean code by:

### 🧑‍🚀 Parthib Dhar
📍 India &nbsp; | &nbsp; 💬 Passionate about Java, Spring Boot, and building things that matter  

> “Code is poetry — and I write APIs that speak human.”

---
