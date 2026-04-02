# Java Logger System

## 🧠 Overview
A modular logging system built in Java that records application events and sends them to multiple destinations such as console, file, and server.

---

## ⚡ Features
- Log levels: DEBUG, INFO, ERROR
- Timestamp for each log
- Multiple outputs:
  - Console
  - File
  - Server (simulated)
- Easily extensible design

---

## 🧩 Components

| Component | Description |
|----------|------------|
| Logger | Main controller (Singleton) |
| LogAppender | Interface for output |
| ConsoleAppender | Prints logs |
| FileAppender | Writes logs to file |
| ServerAppender | Sends logs to server |
| LogLevel | Controls log filtering |

---

## 🧠 Design Patterns Used

### 1. Singleton Pattern
Ensures only one instance of Logger exists.

### 2. Strategy Pattern
Appenders act as interchangeable output strategies.

### 3. Open/Closed Principle
System is open for extension but closed for modification.

---

## 🧩 UML Diagram

```
                +------------------+
                |     Logger       |
                +------------------+
                | - instance       |
                | - appenders[]    |
                | - currentLevel   |
                +------------------+
                | + getInstance()  |
                | + log()          |
                | + addAppender()  |
                +--------+---------+
                         |
                         v
                +------------------+
                |  LogAppender     |
                +------------------+
                | + append()       |
                +--------+---------+
                         |
        -------------------------------------
        |                |                 |
        v                v                 v
+----------------+  +----------------+  +----------------+
|ConsoleAppender |  | FileAppender   |  | ServerAppender |
+----------------+  +----------------+  +----------------+
```

---

## 🔄 How It Works

1. Logger receives log request
2. Checks log level
3. Formats message with timestamp
4. Sends message to all appenders
5. Each appender handles output independently

---

## ⚡ Example

```
[INFO] 2026-04-03T10:30:12 : Application started
```

---

## 🚀 Extensibility

You can add new appenders like:
- DBAppender
- KafkaAppender
- RemoteAppender

Without modifying Logger class.

---

## ⚠️ Limitations

- File writing not optimized
- Synchronous logging
- No configuration file
- Server logging is simulated

---

## 🔥 Future Improvements

- Async logging (queue + worker thread)
- Log rotation
- Config file support
- Formatter strategies
- Retry mechanism

---

## 🧠 Summary

This project demonstrates how to build a scalable logging system using design patterns like Singleton and Strategy.
