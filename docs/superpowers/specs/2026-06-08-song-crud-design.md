# Song CRUD Controller Design

## Overview

Expand the SongController to support full CRUD operations with dedicated input/output DTOs. This replaces the current hardcoded POST endpoint with a proper API that allows users to create, read, update, and delete songs.

## Architecture

### Package Structure
- **Controllers:** `be.kunlabora.music.library.SongController`
- **DTOs:** New package `be.kunlabora.music.library.dto` with three classes:
  - `CreateSongDTO` — input for creating songs
  - `UpdateSongDTO` — input for updating songs
  - `SongResponseDTO` — output for all read operations
- **Entities:** `be.kunlabora.music.library.SongEntity` (updated with setters)
- **Repositories:** `be.kunlabora.music.library.SongRepository` (no changes needed)

### API Endpoints

| Method | Endpoint | Request Body | Response | Status |
|--------|----------|--------------|----------|--------|
| GET | `/api/song` | — | `List<SongResponseDTO>` | 200 |
| POST | `/api/song` | `CreateSongDTO` | `SongResponseDTO` | 201 |
| GET | `/api/song/{id}` | — | `SongResponseDTO` | 200 / 404 |
| PUT | `/api/song/{id}` | `UpdateSongDTO` | `SongResponseDTO` | 200 / 404 |
| DELETE | `/api/song/{id}` | — | — | 204 / 404 |

### DTO Definitions

**CreateSongDTO** (input for POST):
- `title: String`
- `artist: String`
- `album: String`
- `durationInSeconds: int`

**UpdateSongDTO** (input for PUT):
- `title: String`
- `artist: String`
- `album: String`
- `durationInSeconds: int`

**SongResponseDTO** (output for all reads):
- `id: UUID`
- `title: String`
- `artist: String`
- `album: String`
- `durationInSeconds: int`

### Error Handling

- **404 Not Found:** When retrieving, updating, or deleting a song with a non-existent ID
- **400 Bad Request:** For malformed requests (e.g., missing required fields in body)
- **201 Created:** POST operations return 201 with Location header pointing to the new resource
- **204 No Content:** DELETE returns 204 with no body

### SongEntity Updates

Add setter methods to SongEntity to support updates:
- `setTitle(String title)`
- `setArtist(String artist)`
- `setAlbum(String album)`
- `setDurationInSeconds(int durationInSeconds)`

## Implementation Notes

- No input validation beyond what Spring provides (minimal validation per user requirement)
- DTOs use standard Java objects (no special annotations required unless validation is added later)
- Mapping between DTOs and entities is done directly in the controller
- List endpoint returns all songs without pagination
