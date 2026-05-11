# Music Library

A simple music library REST API built with Spring Boot.

## Getting Started

### Dependencies

- Install [asdf](https://asdf-vm.com/)
- Run `asdf plugin add java`
- Run `asdf plugin add gradle`
- Run `asdf install`

### Running locally

- Run `gradle bootRun`

### Build & run in docker

- Run `docker build --tag music-library:latest .`
- Run `docker run --port 8080:8080 music-manager:latest`