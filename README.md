# 🎓 Course Enrollment System

The Course Enrollment System is a RESTful Spring Boot application designed to manage the enrollment of students into academic courses. It also integrates with an external banking service to handle payments securely through a **Feign Client**.

---

## 🔑 Key Features

### 👩‍🎓 Student Features
- Register and retrieve student details
- View available courses
- Enroll in one or multiple courses
- Automatic fee calculation and fund transfer during enrollment

### 🧑‍🏫 Administrator Features
- Add, update, or delete courses
- View student enrollment records
- Manage course pricing and availability

### 💳 Payment Integration
- Integrates with an external bank service using **Feign Client**
- Transfers course fees from student's account to the institution
- Validates payment before confirming enrollment

### ✅ System Validation
- Prevent enrollment if student has insufficient balance
- Ensures data consistency between student, course, and enrollment tables
- Handles exceptions during fund transfer or data persistence

---

## ⚙️ Technologies Used

This project is built using the following technologies:

- **Java 17**: Core programming language
- **Spring Boot**: Framework for building the REST API
- **Spring Data JPA**: ORM for interacting with the database
- **Feign Client**: For calling the external banking service
- **H2 / PostgreSQL / MySQL**: Database options (configurable)
- **JUnit**: For testing service logic
- **Lombok**: For cleaner model classes

---

## 📦 Features Overview

### 🔐 Authentication Module *(Optional for Future)*
- Basic authentication for students and admins (TBD)

### 📝 Enrollment Module
- Accepts student ID and list of course IDs
- Fetches course details and calculates total fee
- Calls bank service to transfer funds
- Enrolls student only if fund transfer is successful

### 🧾 Logging and Exception Handling
- Logs all transactions using `Slf4j`
- Provides meaningful error messages for failure scenarios (e.g., insufficient funds)

---

## 🧪 Example API Call

### `POST /enroll`

```json
{
  "studentId": 1,
  "accountNumber": 123456789,
  "courseList": [
    { "courseId": 101 },
    { "courseId": 102 }
  ]
}
