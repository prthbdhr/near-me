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

## ✅ Future Enhancements

- [ ] Add **R-Tree or PostGIS** support for true spatial indexing
- [ ] Enable **natural language queries** (e.g., “Bookstores Near Me”)

---

## 👨‍💻 Authors

- Made with ❤️ by **Parthib Dhar**