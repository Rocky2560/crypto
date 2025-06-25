# 💰 Crypto Price Alert System

A Spring Boot application that tracks cryptocurrency prices and sends email alerts when a user-defined threshold is reached. Built with Java, Spring Boot, Thymeleaf, and the CoinGecko API.

---

## 🚀 Features

- 🔔 Set alerts for any cryptocurrency using its CoinGecko ID
- 💸 Trigger alert when price goes **above** or **below** a target
- 📧 Email notification sent to the registered address
- 🕒 Scheduled checks every 60 seconds
- 🌐 Simple web interface using Thymeleaf
- 🗂 View and track pending/triggered alerts

---

## 📸 Demo

![Screenshot](screenshots/form.png)

---

## 📦 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Mail**
- **Thymeleaf**
- **H2 In-Memory Database**
- **CoinGecko Public API**

---

## 🛠️ How It Works

1. User submits an alert with:
   - Crypto ID (e.g., `bitcoin`, `ethereum`)
   - Target price
   - Direction (Above/Below)
   - Email address

2. A scheduled task runs every 60 seconds:
   - Calls the CoinGecko API
   - Compares live price with alert target
   - If triggered, sends an email and marks alert as `TRIGGERED`

---

## 🧑‍💻 Getting Started

### Prerequisites

- Java 17+
- Maven or Gradle

### Clone and Run

```bash
git clone https://github.com/your-username/crypto-price-alert.git
cd crypto-price-alert
./mvnw spring-boot:run
