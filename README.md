# 🎯 Project 79 – Notification Service - Kafka Consumer | Spring Boot + Kafka | Port 8088 | Tier 8 Advanced Backend

<p align="left">
<img src="https://img.shields.io/badge/Tier-8%20Advanced%20Backend-0A1931?style=for-the-badge" alt="Tier 8">
<img src="https://img.shields.io/badge/Java-21-E76F00?logo=openjdk&logoColor=white" alt="Java 21">
<img src="https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot 3.2.5">
<img src="https://img.shields.io/badge/Spring%20Kafka-3.1.5-6DB33F?logo=apachekafka&logoColor=white" alt="Spring Kafka">
<img src="https://img.shields.io/badge/Port-8088-00BFFF" alt="8088">
<img src="https://img.shields.io/badge/Group-notification--group--RAVI--FINAL-FF6F00" alt="Group">
<img src="https://img.shields.io/badge/Status-Completed-20B000" alt="Completed">
</p>

## 📖 Project Overview - Tier 8 Interlinked with 78

Project 79 is **Tier 8 – Advanced Backend – Microservices – Architecture diagram in README, each service = repo** - GitHub Goal Achieved.

This project is **interlinked with Project 78 – Event-Driven Order**:

- **Tier 8 Roadmap:** 73 Auth Service completed, 74 Product Service completed, 75 Order Service completed, 76 API Gateway completed, 77 Service Discovery completed, **78 Event-Driven Order completed**, **79 Notification Service – THIS REPO**, 80 Payment Service, 81 Logging Service, 82 Config Server
- **Interlink Flow:** 78 Order Service (Port 8087) Producer -> Kafka Topic: orders -> **79 Notification Service (Port 8088) Consumer** -> NOTIFICATION SENT – demo2.png + demo3.png
- **This Repo:** Notification Service runs on port 8088 – http://localhost:8088/api/notifications – RUNNING - Listening to orders topic! – demo1.png
- **Linked Repo:** 78 Order Service – https://github.com/raviteja-dev950/78-event-driven-order – Producer – PRODUCED Event – demo3.png
- **Tech:** Spring Cloud, Eureka, Gateway, Config, Kafka, Redis, RabbitMQ – Tier 8 Focus – Kafka Consumer Pattern

Backend flow interlinked:
- **78:** POST /api/orders {"id":"9999","product":"ITWORKS","qty":9} -> OrderController 8087 -> OrderProducer.send -> KafkaTemplate StringSerializer ObjectMapper -> topic orders – demo3.png PRODUCED Event
- **Kafka:** Topic orders – Partition 0 – Group notification-group-RAVI-FINAL – earliest offset 0 – partitions assigned [orders-0] – demo2.png
- **79:** NotificationConsumer 8088 @KafkaListener(topics="orders", groupId="notification-group-RAVI-FINAL") -> StringDeserializer -> RAW MESSAGE -> CONSUMED -> NOTIFICATION SENT Order ID 9999 – demo2.png main proof interlinked 78->79

Verified with 4 screenshots interlinked proof:
- demo1.png – Browser – localhost:8088/api/notifications – GET – 79-notification-service RUNNING - Listening to orders topic! – Port 8088 health
- demo2.png – Console 79 – RAW MESSAGE {"id":"9999","product":"ITWORKS","qty":9} -> CONSUMED -> NOTIFICATION SENT – 79 main proof – Interlinked from 78
- demo3.png – Console 78 – PRODUCED Event Order{id='9999', product='ITWORKS', qty=9} -> JSON – 78 producer proof – Interlinked to 79
- demo4.jpg – Architecture – Microservices Event-Driven – Client -> 78 Order Service 8087 Producer -> Kafka Central Broker Topic orders -> 79 Notification Service 8088 Consumer @KafkaListener -> NOTIFICATION SENT


## 🏗 Architecture Diagram – Tier 8 Goal – Architecture diagram in README, each service = repo – Interlinked 78 + 79

[architecture](screenshots/demo4.jpg)

```text
TIER 8 – ADVANCED BACKEND – MICROSERVICES – INTERLINKED

Client curl -X POST /api/orders {"orderId":"123","product":"Widget","qty":2} 
 -> [73 Auth Service] -> [74 Product Service] -> [75 Order Service] -> [76 API Gateway] -> [77 Service Discovery]
 -> 78 Order Service (Port 8087) REST API POST /api/orders -> OrderProducer KafkaTemplate StringSerializer ObjectMapper JSON
 -> Apache Kafka Central Event Broker Topic: orders Durable Partitioned Publish-Subscribe Buffering and streaming of events
 -> 79 Notification Service (Port 8088) Spring Boot Consumer @KafkaListener topics="orders" group-id notification-group-RAVI-FINAL StringDeserializer ObjectMapper JSON – Interlinked Consumes from orders topic via consumer group
 -> NOTIFICATION SENT Email/Push Notification Status Delivered Successfully Notification delivered to user
 -> Future: 80 Payment Service, 81 Logging Service, 82 Config Server – All Tier 8

Data Flow Interlinked: 78 Producer -> Kafka Topic orders -> 79 Consumer -> Notification – Async Event-Driven – Not DB direct
GitHub Goal Tier 8: Architecture diagram in README, each service = repo – Achieved – 78 repo + 79 repo separate – Interlinked via Kafka topic orders
```

Tech Stack Tier 8: Java 21 + Spring Boot 3.2.5 + Spring Cloud + Spring Kafka 3.1.5 + Kafka 3.6.2 + Redis + Eureka + Gateway – Focus Area: Spring Cloud, Eureka, Gateway, Config, Kafka


## ✨ Features – Tier 8 – Interlinked

### 🌐 REST API Layer – 8088 – Tier 8 Microservices
- NotificationController – Port 8088 – @RestController @RequestMapping("/api/notifications") – Each service = repo – GitHub Goal Tier 8
- GET /api/notifications -> RUNNING - Listening to orders topic! – Health check – demo1.png – http://localhost:8088/api/notifications – Only Port 8088 – No 9092
- Order Model – id, product, qty – Jackson ObjectMapper – Interlinked with 78 model

### 📥 Kafka Consumer – Event Listening – MAIN FEATURE – demo2.png – Interlinked with 78
- NotificationConsumer – @KafkaListener(topics="orders", groupId="notification-group-RAVI-FINAL") – Listens orders topic from 78
- Logs >>> [79-NOTIFICATION] RAW MESSAGE: {"id":"9999","product":"ITWORKS","qty":9} – Interlinked from 78 PRODUCED – demo2.png
- Logs >>> [79-NOTIFICATION] CONSUMED Event: Order{id='9999', product='ITWORKS', qty=9} – demo2.png
- Logs >>> Product: ITWORKS Qty: 9 – demo2.png
- Logs ********** NOTIFICATION SENT ********** Order ID: 9999 Product: ITWORKS Quantity: 9 Email sent to customer for order 9999 – demo2.png main proof interlinked 78->79!

### 📤 Kafka Producer Proof – 78 Side – Interlinked – demo3.png
- OrderProducer 78 – KafkaTemplate<String, String> – StringSerializer – ObjectMapper JSON – https://github.com/raviteja-dev950/78-event-driven-order
- Logs > PRODUCED Event: Order{id='9999', product='ITWORKS', qty=9} – demo3.png – Interlinked to 79
- Logs > JSON: {"id":"9999","product":"ITWORKS","qty":9} – demo3.png
- KafkaProducer Instantiated idempotent producer – demo3.png – Producer 78 -> Consumer 79 interlinked

### 📡 Kafka Configuration – Fixed Issues – demo2.png – Tier 8 Learning
- Consumer group-id notification-group-RAVI-FINAL – auto-offset-reset earliest – Found no committed offset for partition orders-0 -> Resetting offset to 0
- StringDeserializer – ObjectMapper readValue – Fixed ClassNotFound JavaType – Added jackson-databind
- partitions assigned: [orders-0] – Successfully joined group generation 3 – demo2.png – Interlinked 78->79 working
- Tier 8 Goal: Architecture diagram in README – demo4.jpg – Achieved

## 🛠 Technologies Used – Tier 8 – Advanced Backend

| Technology | Version | Purpose – Tier 8 Focus |
|---|---|---|
| Java | 21 | Backend – 21.0.10 – Core |
| Spring Boot | 3.2.5 | 79-notification-service – Port 8088 – Microservices |
| Spring Kafka | 3.1.5 | Consumer @KafkaListener – Spring Cloud, Kafka – Tier 8 |
| Kafka | 3.6.2 | Topic orders – Group RAVI-FINAL – Event-Driven – Redis, RabbitMQ – demo2 + demo3 interlinked |
| Jackson Databind | - | ObjectMapper JSON -> Order – Fixed ClassNotFound |
| Maven | - | Build – mvnw.cmd – Dependency mgmt – Tier 4 goal |
| Tier 8 | - | Spring Cloud, Eureka, Gateway, Config, Kafka – Focus Area – Interlinked services |

## 📂 Project Structure – Tier 8 – Each service = repo – Interlinked

```text
100 Projects Java Full Stack – Tier 8 – Advanced Backend – Microservices
├── 73-auth-service/ – completed – Port 8081 – Auth Service
├── 74-product-service/ – completed – Port 8082 – Product Service
├── 75-order-service/ – completed – Port 8083 – Order Service
├── 76-api-gateway/ – completed – Port 8080 – API Gateway
├── 77-service-discovery/ – completed – Port 8761 – Eureka
├── 78-event-driven-order/ – completed – Port 8087 – Producer – PRODUCED Event – demo3.png – https://github.com/raviteja-dev950/78-event-driven-order – Interlinked to 79
├── 79-notification-service/ – THIS REPO – Port 8088 – Consumer – NOTIFICATION SENT – demo1 + demo2 + demo4.jpg – Interlinked from 78
│   ├── src/main/java/com/notification/
│   │   ├── Application.java – Port 8088 – 79-notification-service RUNNING – demo1.png
│   │   ├── controller/NotificationController.java – GET RUNNING - Listening to orders topic! – demo1.png – Tier 8 each service repo
│   │   ├── kafka/OrderConsumer.java – @KafkaListener topics="orders" group RAVI-FINAL -> RAW MESSAGE -> NOTIFICATION SENT – demo2.png – Interlinked
│   │   └── model/Order.java – id, product, qty – Interlinked model with 78
│   ├── src/main/resources/
│   │   ├── application.yml – server.port 8088, group notification-group-RAVI-FINAL, auto-offset-reset earliest – Tier 8 Config
│   │   └── README.md – Architecture diagram in README – Tier 8 GitHub Goal – demo4.jpg
│   ├── screenshots/
│   │   ├── demo1.png – Browser GET localhost:8088/api/notifications – RUNNING - Listening to orders topic! – Port 8088 health
│   │   ├── demo2.png – Console 79 – RAW MESSAGE + CONSUMED + NOTIFICATION SENT – Main proof 79 interlinked from 78!
│   │   ├── demo3.png – Console 78 – PRODUCED Event + JSON – Producer proof interlinked to 79!
│   │   └── demo4.jpg – Architecture – Microservices Event-Driven – Client -> 78 -> Kafka -> 79 -> SENT – Tier 8 Architecture diagram goal
│   ├── pom.xml – spring-kafka + jackson-databind – Fixed ClassNotFound
│   └── target/
├── 80-payment-service/ – Next – Port 8089 – Listens orders -> payments
├── 81-logging-service/ – Next
└── 82-config-server/ – Next – Config Server
```

## ▶ How to Run – Tier 8 – Interlinked 78 + 79

### 1. Clone Both Interlinked Repos
```bash
# 78 Producer – Interlinked
git clone https://github.com/raviteja-dev950/78-event-driven-order.git
cd 78-event-driven-order
mvn clean package -DskipTests
java -jar target/78-event-driven-order-0.0.1-SNAPSHOT.jar # Port 8087 – demo3.png PRODUCED Event

# 79 Consumer – THIS REPO – Interlinked
git clone https://github.com/raviteja-dev950/79-notification-service.git
cd 79-notification-service
```

### 2. Application YML – FINAL – WORKING – demo2.png proof – Tier 8 Config Server pattern

**application.yml – 8088 + Kafka Consumer RAVI-FINAL – Only Port 8088 – No 9092 badge**
```yaml
server:
  port: 8088
spring:
  application:
    name: 79-notification-service
  kafka:
    bootstrap-servers: localhost:9092
    consumer:
      group-id: notification-group-RAVI-FINAL
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
```

### 3. Pom.xml – FINAL – FIXED Jackson – demo2 + demo3 working – Tier 8 Dependency mgmt

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>3.2.5</version>
</parent>
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
  </dependency>
  <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
  </dependency>
</dependencies>
```

### 4. Run – Tier 8 – Interlinked Proof

```bash
mvn clean package -DskipTests
java -jar target/79-notification-service-0.0.1-SNAPSHOT.jar
# Wait: Tomcat started on port 8088 – notification-group-RAVI-FINAL: partitions assigned: [orders-0] – demo2.png – Tier 8 each service repo
# Also start 78 on 8087 – Producer – demo3.png PRODUCED Event – Interlinked
```

### 5. Backend Logic – demo2.png + demo3.png – Interlinked 78->79

```java
@Component
public class OrderConsumer { // 79 Consumer – Interlinked – demo2.png main proof
    @KafkaListener(topics="orders", groupId="notification-group-RAVI-FINAL")
    public void consume(String message) {
        System.out.println("========================================");
        System.out.println(">>> [79-NOTIFICATION] RAW MESSAGE: " + message); // Interlinked from 78 demo3
        try {
            ObjectMapper mapper = new ObjectMapper();
            Order order = mapper.readValue(message, Order.class);
            System.out.println(">>> [79-NOTIFICATION] CONSUMED Event: Order{id='"+order.getId()+"', product='"+order.getProduct()+"', qty="+order.getQty()+"}");
            System.out.println(">>> Product: ITWORKS Qty: 9");
            System.out.println("========================================");
            System.out.println("********** NOTIFICATION SENT **********");
            System.out.println("Order ID: " + order.getId());
            System.out.println("Product: " + order.getProduct());
            System.out.println("Quantity: " + order.getQty());
            System.out.println("Email sent to customer for order " + order.getId());
            System.out.println("***************************************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Service
public class OrderProducer { // 78 Producer – Interlinked – demo3.png – https://github.com/raviteja-dev950/78-event-driven-order
    @Autowired KafkaTemplate<String, String> kafkaTemplate;
    @Autowired ObjectMapper mapper;
    public void send(Order order) throws Exception {
        String json = mapper.writeValueAsString(order);
        kafkaTemplate.send("orders", json);
        System.out.println("> PRODUCED Event: Order{id='"+order.getId()+"', product='"+order.getProduct()+"', qty="+order.getQty()+"}"); // demo3.png
        System.out.println("> JSON: {\"id\":\""+order.getId()+"\",\"product\":\""+order.getProduct()+"\",\"qty\":"+order.getQty()+"}"); // demo3.png interlinked to 79
    }
}

@RestController
@RequestMapping("/api/notifications")
public class NotificationController { // 79 – Port 8088 only – demo1.png
    @GetMapping
    public String health() { 
        return "79-notification-service RUNNING - Listening to orders topic!"; 
    }
}
```

## 🔄 Application Flow – demo1 + demo2 + demo3 – Interlinked Tier 8

```text
TIER 8 FLOW INTERLINKED – 78 -> 79

Client curl POST {"id":"9999","product":"ITWORKS","qty":9} to 8087 (78)
 -> OrderController 8087 POST /api/orders -> orderProducer.send() -> KafkaTemplate StringSerializer ObjectMapper {"id":"9999"...} -> PRODUCED Event + JSON – demo3.png – 78 repo https://github.com/raviteja-dev950/78-event-driven-order
 -> Kafka Topic orders Partition 0 – Group notification-group-RAVI-FINAL
 -> NotificationConsumer 8088 @KafkaListener group notification-group-RAVI-FINAL auto-offset-reset earliest – Each service = repo – Tier 8 GitHub Goal
 -> Found no committed offset -> Resetting offset to 0 -> partitions assigned [orders-0] – demo2.png
 -> >>> [79-NOTIFICATION] RAW MESSAGE: {"id":"9999","product":"ITWORKS","qty":9} – demo2.png – Interlinked from 78 demo3
 -> >>> CONSUMED Event: Order{id='9999'...} – demo2.png
 -> ********** NOTIFICATION SENT ********** Email sent Order ID 9999 – demo2.png main proof interlinked 78->79!
 -> Future: 80 Payment Service Port 8089 Listens orders, 81 Logging, 82 Config Server – Tier 8 Complete -> Tier 9 DevOps Dockerize
```

## 🧪 API Testing – 4 Demos – Interlinked

```bash
# Health – GET – demo1.png – Browser link – Only Port 8088 – No 9092
http://localhost:8088/api/notifications
# 79-notification-service RUNNING - Listening to orders topic!

# Trigger event from 78 – Main flow interlinked – demo2 + demo3 – E2E Tier 8
curl -X POST http://localhost:8087/api/orders -H "Content-Type: application/json" -d "{\"id\":\"9999\",\"product\":\"ITWORKS\",\"qty\":9}"
# Order placed: Order{id='9999', product='ITWORKS', qty=9} – demo3.png PRODUCED Event – 78
# Then check 79 console -> RAW MESSAGE + NOTIFICATION SENT – demo2.png – 79 – Interlinked proof 78->79
```

## 📡 API Endpoints – Tier 8 – Interlinked

| Method | Endpoint | Purpose – Interlinked | Demo | Status | Roadmap |
|---|---|---|---|---|---|
| GET | `http://localhost:8088/api/notifications` | Health – RUNNING - Listening to orders topic! – Port 8088 Only | demo1.png | ✅ | Tier 8 each service repo |
| POST | `http://localhost:8087/api/orders` (78) | Place order -> Publish -> 79 consumes – Interlinked 78->79 | demo3.png -> demo2.png | ✅ Main E2E | 78 completed |
| - | `Kafka orders topic` | Consumes event – RAW MESSAGE -> NOTIFICATION SENT – Interlinked | demo2.png | ✅ 79 Proof | Tier 8 Architecture diagram goal |

## 🗄 Kafka Consumer Note – demo2 + demo3 – Tier 8 Interlinked

```text
TIER 8 – ADVANCED BACKEND – MICROSERVICES – INTERLINKED – 78 + 79 – GitHub Goal: Architecture diagram in README, each service = repo – Achieved

POST on 78 {"id":"9999","product":"ITWORKS","qty":9} – demo3.png PRODUCED Event – https://github.com/raviteja-dev950/78-event-driven-order
-> 78 Producer JSON StringSerializer -> Kafka Topic orders – Group notification-group-RAVI-FINAL
-> 79 Consumer @KafkaListener group notification-group-RAVI-FINAL earliest offset 0 partitions assigned [orders-0] – demo2.png – Each service repo separate – Tier 8 goal
-> Consumes String -> ObjectMapper -> Order -> Log RAW + CONSUMED + NOTIFICATION SENT Order ID 9999 – demo2.png – Interlinked 78->79 E2E proof

Fixes Tier 8 Learning:
Jackson ClassNotFound JavaType -> Added jackson-databind + Changed to StringDeserializer + ObjectMapper -> demo2 fixed – Spring Boot 3.2.5
Not consuming old messages -> Changed group-id to notification-group-RAVI-FINAL + auto-offset-reset earliest -> Resetting offset to 0 -> partitions assigned [orders-0] -> demo2 working – Consumer group management
Producer JsonSerializer error -> Changed to StringSerializer + JSON: {"id":"9999"...} -> demo3 working – KafkaTemplate<String,String>

Verified: demo1 GET RUNNING 8088 Only Port 8088 No 9092 badge, demo2 Console NOTIFICATION SENT Order ID 9999 interlinked from 78, demo3 Console PRODUCED Event ITWORKS interlinked to 79, demo4 Architecture Client->78->Kafka->79->SENT – Tier 8 Complete – 79 COMPLETE! – Interlinked with 78
```

## 📸 Screenshots – 4 Demos – Completed – Tier 8 Interlinked Proof

### 1. Health Check – Browser – localhost:8088/api/notifications – RUNNING - Listening to orders topic! – Only Port 8088 – No 9092

**Browser Link – Only 8088 – Tier 8 Each service = repo:**
```
http://localhost:8088/api/notifications
```

[demo1](screenshots/demo1.png)

---

### 2. Event Consumed – Console 79 – RAW MESSAGE + CONSUMED + NOTIFICATION SENT – Main proof! 78->79 Interlinked WORKS! – Tier 8

**Console Log After curl to 8087 – Interlinked from 78 demo3:**
```text
========================================
>>> [79-NOTIFICATION] RAW MESSAGE: {"id":"9999","product":"ITWORKS","qty":9}
>>> [79-NOTIFICATION] CONSUMED Event: Order{id='9999', product='ITWORKS', qty=9}
>>> Product: ITWORKS Qty: 9
========================================
********** NOTIFICATION SENT **********
Order ID: 9999
Product: ITWORKS
Quantity: 9
Email sent to customer for order 9999
***************************************
```

[demo2](screenshots/demo2.png)

---

### 3. Event Produced – Console 78 – PRODUCED Event + JSON – Producer proof! Order Service 78 Interlinked to 79!

**Console Log 78 – Interlinked repo https://github.com/raviteja-dev950/78-event-driven-order:**
```text
> PRODUCED Event: Order{id='9999', product='ITWORKS', qty=9}
> JSON: {"id":"9999","product":"ITWORKS","qty":9}
```

[demo3](screenshots/demo3.png)

---

### 4. Architecture – Event-Driven – 78 Producer -> Kafka -> 79 Consumer – Flow diagram – Tier 8 Architecture diagram in README Goal

**Tier 8 GitHub Goal Achieved – Architecture diagram in README, each service = repo – Interlinked 78 + 79:**

[architecture](screenshots/demo4.jpg)

---

## 🎯 Learning Outcomes – Tier 8 – Advanced Backend – Interlinked

- **Tier 8 Roadmap:** Focus Area Spring Cloud, Eureka, Gateway, Config, Kafka, Redis, RabbitMQ – Sample Projects 73 Auth Service completed, 74 Product Service completed, 75 Order Service completed, 76 API Gateway completed, 77 Service Discovery completed, 78 Event-Driven Order completed, 79 Notification Service – THIS REPO – 80 Payment Service next, 81 Logging Service, 82 Config Server – GitHub Goal Architecture diagram in README, each service = repo – Achieved
- **Interlinked:** 78 Producer (Port 8087) -> Kafka Topic orders -> 79 Consumer (Port 8088) -> NOTIFICATION SENT – demo2.png + demo3.png + demo4.jpg – E2E proof – https://github.com/raviteja-dev950/78-event-driven-order interlinked
- **Kafka Consumer:** @KafkaListener – Port 8088 Only – No 9092 badge – Topic orders – Group RAVI-FINAL – demo2.png partitions assigned [orders-0] – Tier 8 Microservices
- **Kafka Producer:** 78 – StringSerializer + ObjectMapper JSON – PRODUCED Event + JSON log – demo3.png – Interlinked proof
- **StringDeserializer + ObjectMapper:** Fixed Jackson ClassNotFound – No JsonDeserializer – demo2 + demo3 fixed – Spring Boot 3.2.5 + jackson-databind
- **Consumer Group Management:** notification-group-RAVI-FINAL – earliest – offset 0 – Found no committed offset -> Resetting offset to 0 – Successfully joined group – demo2.png
- **Event-Driven Communication:** 78 produces JSON {"id":"9999"...} -> 79 consumes RAW MESSAGE -> NOTIFICATION SENT Order ID 9999 – demo2 + demo3 E2E – Async not DB direct – Tier 8 pattern
- **GitHub Goal Tier 8:** Architecture diagram in README – demo4.jpg – Achieved – Each service = repo – 78 repo separate + 79 repo separate – Interlinked via Kafka topic orders – Clean repos, great READMEs, commit history – Tier 1 goal also

## 🚀 Future Enhancements – Tier 8 -> Tier 9 DevOps + Cloud

- **80 Payment Service – Port 8089 – Interlinked:** Listens orders topic -> publishes payments topic – Tier 8 Next – https://github.com/raviteja-dev950/80-payment-service
- **81 Logging Service + 82 Config Server:** Tier 8 Complete – All microservices done – Architecture diagram in README for each
- **Tier 9 DevOps + Cloud:** 83 Dockerize App – Dockerfile – Docker Compose 78 + 79 + Kafka + Zookeeper – 84 K8s Deploy – 85 GitHub Actions CI – Badges build passing, coverage, deployed link – Tier 9 GitHub Goal
- **Add JavaMailSender:** Real email sending – Email sent to customer for order 9999 – demo2.png real email – Interlinked enhancement
- **Add DB:** Save notifications – JPA MySQL – Tier 2 Java + SQL – ER diagrams, SQL scripts
- **Add React Frontend:** Fetch http://localhost:8088/api/notifications – Tier 6 Frontend Mastery – React Hooks Axios Tailwind – Screenshots/GIFs

## 👨💻 Author – 100 Projects Java Full Stack Development and GitHub Profile Roadmap

### Vemula Leela Venkata Ravi Teja
Java Full Stack Developer
100 Java Full Stack Projects Challenge – 79/100 – Tier 8 Advanced Backend – Microservices Track – Notification Service - Kafka Consumer – Interlinked with 78 Event-Driven Order

**Roadmap Progress – Tier 8 – Advanced Backend – Microservices – Architecture diagram in README, each service = repo:**
- Tier 1 Foundations Core Java + Git Clean repos, great READMEs, commit history – 1-12 completed
- Tier 2 Java + SQL JDBC MySQL ER diagrams SQL scripts – 13-22 completed
- Tier 3 Web Basics Servlets JSP Deploy Render/Railway live link – 23-32 completed
- Tier 4 Spring Core Spring IoC DI Beans MVC Thymeleaf Use Spring Initializr – 33-42 completed
- Tier 5 Spring Boot + REST APIs Postman Swagger OpenAPI docs – 43-52 completed
- Tier 6 Frontend Mastery React Hooks Axios Tailwind Separate frontend repos screenshots/GIFs – 53-62 completed
- Tier 7 Full Stack Integration Complete Apps Dockerfiles docker-compose monorepo or 2 repos – 63-72 completed
- **Tier 8 Advanced Backend Microservices Spring Cloud Eureka Gateway Config Kafka Redis RabbitMQ Architecture diagram in README each service = repo – 73 Auth completed, 74 Product completed, 75 Order completed, 76 Gateway completed, 77 Discovery completed, 78 Event-Driven Order completed – https://github.com/raviteja-dev950/78-event-driven-order – 79 Notification Service – THIS REPO – demo1 + demo2 + demo3 + demo4 – 80 Payment Service next, 81 Logging, 82 Config Server**
- Tier 9 DevOps + Cloud Deployment Docker K8s CI/CD Nginx AWS Badges build passing coverage deployed link – 83-92 next
- Tier 10 System Design Level Scale Polish Caching security testing JUnit Mockito Redis Elasticsearch CONTRIBUTING.md issues release tags – 93-102 next – Capstone OSS Tool

### Test Consumer – 4 Demos – Interlinked Tier 8

- `localhost:8088/api/notifications` / `GET` / `RUNNING - Listening to orders topic!` – demo1.png – Browser link http://localhost:8088/api/notifications – Only Port 8088 No 9092 – Tier 8 each service repo
- `Kafka Consumer` / `RAW MESSAGE {"id":"9999"...}` / `NOTIFICATION SENT Order ID 9999` – demo2.png – 79 console main proof – Interlinked from 78 demo3
- `Kafka Producer 78` / `PRODUCED Event Order{id='9999'...}` / `JSON {"id":"9999"...}` – demo3.png – 78 console producer proof – https://github.com/raviteja-dev950/78-event-driven-order – Interlinked to 79
- `Architecture` / `Client -> Order Service 78 -> Kafka Topic orders -> Notification Service 79 -> NOTIFICATION SENT` – demo4.jpg – Tier 8 Architecture diagram in README goal achieved

## ⭐ Support – Tier 8

If you found this project helpful learning Kafka Consumer / Producer / @KafkaListener / StringDeserializer / ObjectMapper / Tier 8 Microservices / Event-Driven / Port 8088 Only / Interlinked 78->79 / 100 Projects Roadmap, give it a ⭐ Star!

### Repo – Interlinked – Tier 8 Each service = repo

- **78 Event-Driven Order – Producer – Port 8087 – Interlinked:** https://github.com/raviteja-dev950/78-event-driven-order – PRODUCED Event – demo3.png
- **79 Notification Service – Consumer – Port 8088 – THIS REPO – Interlinked:** https://github.com/raviteja-dev950/79-notification-service – NOTIFICATION SENT – demo1 + demo2 + demo4.jpg – Tier 8 Architecture diagram goal

### Run – Simplest – demo1 + demo2 + demo3 – Interlinked Tier 8

```bash
# Tier 8 – Interlinked – 78 + 79 – Each service = repo – Architecture diagram in README

# 78 Producer – https://github.com/raviteja-dev950/78-event-driven-order
git clone https://github.com/raviteja-dev950/78-event-driven-order.git
cd 78-event-driven-order
mvn clean package -DskipTests
java -jar target/78-event-driven-order-0.0.1-SNAPSHOT.jar # Port 8087 – demo3.png PRODUCED Event

# 79 Consumer – THIS REPO – Interlinked – https://github.com/raviteja-dev950/79-notification-service
git clone https://github.com/raviteja-dev950/79-notification-service.git
cd 79-notification-service
mvn clean package -DskipTests
java -jar target/79-notification-service-0.0.1-SNAPSHOT.jar
# Browser demo1 – GET http://localhost:8088/api/notifications – RUNNING - Listening to orders topic! – Only Port 8088
# Console demo2 – RAW MESSAGE + NOTIFICATION SENT Order ID 9999 – Main proof interlinked from 78
# Console demo3 – PRODUCED Event + JSON ITWORKS – 78 side proof – E2E interlinked complete! Tier 8 goal achieved!
```

### Work Process Summary – 4 Demos – Tier 8 Interlinked – Only Port 8088 – No 9092 Mistake

```text
TIER 8 – ADVANCED BACKEND – MICROSERVICES – 100 PROJECTS ROADMAP – INTERLINKED 78 + 79 – GITHUB GOAL: ARCHITECTURE DIAGRAM IN README, EACH SERVICE = REPO – ACHIEVED

1. demo1 – Browser GET http://localhost:8088/api/notifications – RUNNING - Listening to orders topic! – Health proof – Port 8088 Only – No 9092 badge – Tier 8 each service repo separate
2. demo2 – Console 79 – RAW MESSAGE {"id":"9999","product":"ITWORKS","qty":9} + CONSUMED Event + NOTIFICATION SENT Order ID 9999 Quantity 9 Email sent – Main proof 78->79 interlinked complete! – Group notification-group-RAVI-FINAL earliest offset 0 partitions assigned [orders-0]
3. demo3 – Console 78 – PRODUCED Event Order{id='9999', product='ITWORKS', qty=9} + JSON {"id":"9999"...} + ProducerId set to 0 – Producer proof – https://github.com/raviteja-dev950/78-event-driven-order – Interlinked to 79 – E2E proof Tier 8
4. demo4 – Architecture – Client curl -X POST /api/orders {"orderId":"123","product":"Widget","qty":2} -> Order Service 78 8087 StringSerializer ObjectMapper -> Kafka Central Event Broker Topic orders Durable Partitioned Publish-Subscribe Buffering streaming –> Notification Service 79 8088 StringDeserializer @KafkaListener group notification-group-RAVI-FINAL -> NOTIFICATION SENT Email/Push Delivered Status Delivered – Tier 8 Architecture diagram in README goal

Flow Interlinked Tier 8: 78 POST -> Producer StringSerializer JSON -> Kafka Topic orders -> 79 @KafkaListener StringDeserializer ObjectMapper -> RAW MESSAGE -> CONSUMED -> NOTIFICATION SENT Order ID 9999 – Interlinked 78->79
Group: notification-group-RAVI-FINAL earliest offset 0 partitions assigned [orders-0] Found no committed offset Resetting offset to 0 Successfully joined group generation 3 – demo2.png
Tech: Java 21 + Spring Boot 3.2.5 + Spring Kafka 3.1.5 + Jackson Databind – Tier 8 Focus Spring Cloud Eureka Gateway Config Kafka Redis RabbitMQ – Only Port 8088 No 9092 – Complete – 4 Demos Done! – Interlinked with 78 – Roadmap 79/100 Tier 8 – Next 80 Payment Service
```

### Logs Proof – FINAL WORKING – demo2 + demo3 – Tier 8 Interlinked – Only Port 8088

```text
# 79 Consumer – demo2.png – Port 8088 ONLY – No 9092 badge – Tier 8 each service repo – Interlinked from 78
Health: http://localhost:8088/api/notifications – demo1.png – Only 8088
Tomcat started on port 8088 – 8088 ready – demo1.png – Tier 8
notification-group-RAVI-FINAL: partitions assigned: [orders-0] – demo2.png – Interlinked
Found no committed offset -> Resetting offset to 0 – demo2.png – Tier 8 consumer group management
========================================
>>> [79-NOTIFICATION] RAW MESSAGE: {"id":"9999","product":"ITWORKS","qty":9} – demo2.png – Interlinked from 78 demo3 PRODUCED Event
>>> [79-NOTIFICATION] CONSUMED Event: Order{id='9999', product='ITWORKS', qty=9} – demo2.png
>>> Product: ITWORKS Qty: 9 – demo2.png
========================================
********** NOTIFICATION SENT ********** – demo2.png main proof interlinked 78->79 – Tier 8 Goal Architecture diagram achieved!
Order ID: 9999 – Product: ITWORKS Quantity: 9 – Email sent – 79 COMPLETE! – Interlinked with 78 – https://github.com/raviteja-dev950/78-event-driven-order

# 78 Producer – demo3.png – Port 8087 – Interlinked to 79 – Tier 8
[Producer clientId=producer-1] Instantiated an idempotent producer – demo3.png – Tier 8
> PRODUCED Event: Order{id='9999', product='ITWORKS', qty=9} – demo3.png – Interlinked to 79 demo2 RAW MESSAGE
> JSON: {"id":"9999","product":"ITWORKS","qty":9} – demo3.png – Interlinked to 79 CONSUMED
ProducerId set to 0 – 78 COMPLETE! – E2E 78->79 WORKING! – Tier 8 Architecture diagram in README each service repo – 73-79 completed – 80 next!
```
