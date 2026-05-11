# Music Library

A simple music library REST API built with Spring Boot.

## Features

- CRUD operations for Artists and Songs
- RESTful API endpoints
- H2 embedded database (development)
- PostgreSQL support (production)
- Containerized with Podman

## Getting Started

### Prerequisites
- Java 25
- Gradle
- Podman (for containerization)

### Run Locally

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

### API Endpoints

#### Artists
- `GET /api/artists` - List all artists
- `POST /api/artists` - Create a new artist
- `GET /api/artists/{id}` - Get artist by ID
- `PUT /api/artists/{id}` - Update artist
- `DELETE /api/artists/{id}` - Delete artist

#### Songs
- `GET /api/songs` - List all songs
- `POST /api/songs` - Create a new song
- `GET /api/songs/{id}` - Get song by ID
- `PUT /api/songs/{id}` - Update song
- `DELETE /api/songs/{id}` - Delete song

## Testing

```bash
./gradlew test
```

## Deployment

See [DEPLOYMENT.md](DEPLOYMENT.md) for containerization and deployment instructions.
