# JavaFX Docker Application

This is a JavaFX application that runs inside a Docker container and provides web-based access via noVNC.

## 🚀 Quick Start

### 1. Clone the repository

```bash
git clone <your-repository>
```

### 2. Build and run the container

```bash
docker compose up --build
```

### 3. Open the application in the browser

Once the container is running, open URL:
[http://localhost:6080/vnc_lite.html](http://localhost:6080/vnc_lite.html)

## 🛠 Commands

### Run

```bash
# Run in the background
docker compose up -d

# Run with rebuild
docker compose up --build

# View logs
docker compose logs -f
```

### Stop

```bash
# Stop containers
docker compose down

# Stop and remove volumes
docker compose down -v
```

### Rebuild

```bash
# Full rebuild without cache
docker compose build --no-cache
```

## 📂 Project Structure

```
javaFX-tutorial/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           ├── App.java
│       │           ├── PrimaryController.java
│       │           └── SecondaryController.java
│       └── resources/
│           └── com/
│               └── example/
│                   ├── primary.fxml
│                   ├── secondary.fxml
│                   └── styles.css
├── pom.xml
├── Dockerfile
├── docker-compose.yml
├── .gitignore
└── README.md
```
