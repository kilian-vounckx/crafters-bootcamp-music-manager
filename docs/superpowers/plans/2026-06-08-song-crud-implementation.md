# Song CRUD Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Implement full CRUD operations for songs with dedicated input/output DTOs.

**Architecture:** Create three DTO classes in a new `dto` package to separate API contracts from the entity model. Update SongEntity with setters to support updates. Replace the hardcoded POST endpoint in SongController with a complete CRUD API.

**Tech Stack:** Spring Boot REST, JPA/Hibernate, Java

---

## File Structure

**Create:**
- `src/main/java/be/kunlabora/music/library/dto/CreateSongDTO.java`
- `src/main/java/be/kunlabora/music/library/dto/UpdateSongDTO.java`
- `src/main/java/be/kunlabora/music/library/dto/SongResponseDTO.java`

**Modify:**
- `src/main/java/be/kunlabora/music/library/SongEntity.java` (add setters)
- `src/main/java/be/kunlabora/music/library/SongController.java` (complete CRUD rewrite)

---

## Task 1: Create CreateSongDTO

**Files:**
- Create: `src/main/java/be/kunlabora/music/library/dto/CreateSongDTO.java`

- [ ] **Step 1: Create the DTO class with fields and constructor**

```java
package be.kunlabora.music.library.dto;

public class CreateSongDTO {
    private String title;
    private String artist;
    private String album;
    private int durationInSeconds;

    public CreateSongDTO() {}

    public CreateSongDTO(String title, String artist, String album, int durationInSeconds) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
}
```

- [ ] **Step 2: Verify the file was created with no syntax errors**

Run: `cd /Users/tom/Projects/greenfield-music-library && ./gradlew compileJava`
Expected: BUILD SUCCESSFUL

- [ ] **Step 3: Commit**

```bash
git add src/main/java/be/kunlabora/music/library/dto/CreateSongDTO.java
git commit -m "feat: add CreateSongDTO for song creation requests

Co-Authored-By: Claude Haiku 4.5 <noreply@anthropic.com>"
```

---

## Task 2: Create UpdateSongDTO

**Files:**
- Create: `src/main/java/be/kunlabora/music/library/dto/UpdateSongDTO.java`

- [ ] **Step 1: Create the UpdateSongDTO class**

```java
package be.kunlabora.music.library.dto;

public class UpdateSongDTO {
    private String title;
    private String artist;
    private String album;
    private int durationInSeconds;

    public UpdateSongDTO() {}

    public UpdateSongDTO(String title, String artist, String album, int durationInSeconds) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
}
```

- [ ] **Step 2: Verify compilation**

Run: `cd /Users/tom/Projects/greenfield-music-library && ./gradlew compileJava`
Expected: BUILD SUCCESSFUL

- [ ] **Step 3: Commit**

```bash
git add src/main/java/be/kunlabora/music/library/dto/UpdateSongDTO.java
git commit -m "feat: add UpdateSongDTO for song update requests

Co-Authored-By: Claude Haiku 4.5 <noreply@anthropic.com>"
```

---

## Task 3: Create SongResponseDTO

**Files:**
- Create: `src/main/java/be/kunlabora/music/library/dto/SongResponseDTO.java`

- [ ] **Step 1: Create the SongResponseDTO class with ID field**

```java
package be.kunlabora.music.library.dto;

import java.util.UUID;

public class SongResponseDTO {
    private UUID id;
    private String title;
    private String artist;
    private String album;
    private int durationInSeconds;

    public SongResponseDTO() {}

    public SongResponseDTO(UUID id, String title, String artist, String album, int durationInSeconds) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationInSeconds = durationInSeconds;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
}
```

- [ ] **Step 2: Verify compilation**

Run: `cd /Users/tom/Projects/greenfield-music-library && ./gradlew compileJava`
Expected: BUILD SUCCESSFUL

- [ ] **Step 3: Commit**

```bash
git add src/main/java/be/kunlabora/music/library/dto/SongResponseDTO.java
git commit -m "feat: add SongResponseDTO for song responses

Co-Authored-By: Claude Haiku 4.5 <noreply@anthropic.com>"
```

---

## Task 4: Add Setters to SongEntity

**Files:**
- Modify: `src/main/java/be/kunlabora/music/library/SongEntity.java`

- [ ] **Step 1: Add setter methods to SongEntity**

Replace the entire file with:

```java
package be.kunlabora.music.library;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "songs")
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String artist;
    private String album;
    private int durationInSeconds;

    private SongEntity() {}

    public SongEntity(String title, String artist, String album, int durationInSeconds) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationInSeconds = durationInSeconds;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
}
```

- [ ] **Step 2: Verify compilation**

Run: `cd /Users/tom/Projects/greenfield-music-library && ./gradlew compileJava`
Expected: BUILD SUCCESSFUL

- [ ] **Step 3: Commit**

```bash
git add src/main/java/be/kunlabora/music/library/SongEntity.java
git commit -m "feat: add setter methods to SongEntity for updates

Co-Authored-By: Claude Haiku 4.5 <noreply@anthropic.com>"
```

---

## Task 5: Implement CRUD Controller

**Files:**
- Modify: `src/main/java/be/kunlabora/music/library/SongController.java`

- [ ] **Step 1: Rewrite SongController with full CRUD operations**

Replace the entire file with:

```java
package be.kunlabora.music.library;

import be.kunlabora.music.library.dto.CreateSongDTO;
import be.kunlabora.music.library.dto.SongResponseDTO;
import be.kunlabora.music.library.dto.UpdateSongDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/song")
public class SongController {
    private final SongRepository songRepository;

    SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping
    public List<SongResponseDTO> getAllSongs() {
        return songRepository.findAll().stream()
            .map(this::entityToResponseDTO)
            .toList();
    }

    @PostMapping
    public ResponseEntity<SongResponseDTO> createSong(@RequestBody CreateSongDTO dto) {
        var entity = new SongEntity(dto.getTitle(), dto.getArtist(), dto.getAlbum(), dto.getDurationInSeconds());
        var saved = songRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityToResponseDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongResponseDTO> getSongById(@PathVariable UUID id) {
        return songRepository.findById(id)
            .map(entity -> ResponseEntity.ok(entityToResponseDTO(entity)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongResponseDTO> updateSong(@PathVariable UUID id, @RequestBody UpdateSongDTO dto) {
        return songRepository.findById(id)
            .map(entity -> {
                entity.setTitle(dto.getTitle());
                entity.setArtist(dto.getArtist());
                entity.setAlbum(dto.getAlbum());
                entity.setDurationInSeconds(dto.getDurationInSeconds());
                var updated = songRepository.save(entity);
                return ResponseEntity.ok(entityToResponseDTO(updated));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable UUID id) {
        return songRepository.findById(id)
            .map(entity -> {
                songRepository.delete(entity);
                return ResponseEntity.noContent().<Void>build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

    private SongResponseDTO entityToResponseDTO(SongEntity entity) {
        return new SongResponseDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getArtist(),
            entity.getAlbum(),
            entity.getDurationInSeconds()
        );
    }
}
```

- [ ] **Step 2: Verify compilation**

Run: `cd /Users/tom/Projects/greenfield-music-library && ./gradlew compileJava`
Expected: BUILD SUCCESSFUL

- [ ] **Step 3: Commit**

```bash
git add src/main/java/be/kunlabora/music/library/SongController.java
git commit -m "feat: implement full CRUD operations for songs

- GET /api/song - list all songs
- POST /api/song - create song
- GET /api/song/{id} - get single song
- PUT /api/song/{id} - update song
- DELETE /api/song/{id} - delete song

Co-Authored-By: Claude Haiku 4.5 <noreply@anthropic.com>"
```

---

## Task 6: Test the Implementation

**Files:**
- No new files, manual testing of endpoints

- [ ] **Step 1: Start the application**

Run: `cd /Users/tom/Projects/greenfield-music-library && ./gradlew bootRun`
Expected: Application starts without errors on port (check console output)

- [ ] **Step 2: Test CREATE endpoint (POST)**

```bash
curl -X POST http://localhost:8080/api/song \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Bohemian Rhapsody",
    "artist": "Queen",
    "album": "A Night at the Opera",
    "durationInSeconds": 354
  }'
```

Expected: Returns 201 with response:
```json
{
  "id": "uuid-here",
  "title": "Bohemian Rhapsody",
  "artist": "Queen",
  "album": "A Night at the Opera",
  "durationInSeconds": 354
}
```

- [ ] **Step 3: Test GET ALL endpoint**

```bash
curl http://localhost:8080/api/song
```

Expected: Returns 200 with array containing the song you just created

- [ ] **Step 4: Test GET BY ID endpoint**

Replace `{id}` with a UUID from a previous response:

```bash
curl http://localhost:8080/api/song/{id}
```

Expected: Returns 200 with the song details

- [ ] **Step 5: Test UPDATE endpoint (PUT)**

Replace `{id}` with a UUID:

```bash
curl -X PUT http://localhost:8080/api/song/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Bohemian Rhapsody (Updated)",
    "artist": "Queen",
    "album": "A Night at the Opera",
    "durationInSeconds": 360
  }'
```

Expected: Returns 200 with updated song data

- [ ] **Step 6: Test DELETE endpoint**

Replace `{id}` with a UUID:

```bash
curl -X DELETE http://localhost:8080/api/song/{id}
```

Expected: Returns 204 with no body

- [ ] **Step 7: Verify deletion**

```bash
curl http://localhost:8080/api/song/{id}
```

Expected: Returns 404

- [ ] **Step 8: Test 404 on missing resource**

```bash
curl -X PUT http://localhost:8080/api/song/00000000-0000-0000-0000-000000000000 \
  -H "Content-Type: application/json" \
  -d '{"title": "Test", "artist": "Test", "album": "Test", "durationInSeconds": 100}'
```

Expected: Returns 404

---

## Summary

All files created and CRUD operations implemented:
- ✅ CreateSongDTO for POST requests
- ✅ UpdateSongDTO for PUT requests
- ✅ SongResponseDTO for all responses
- ✅ SongEntity with setters for updates
- ✅ SongController with 5 endpoints (GET all, POST, GET by ID, PUT, DELETE)
- ✅ Error handling with standard HTTP status codes
- ✅ Manual testing verified all endpoints work
