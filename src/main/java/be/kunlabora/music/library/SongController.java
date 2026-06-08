package be.kunlabora.music.library;

import be.kunlabora.music.library.dto.CreateSongDTO;
import be.kunlabora.music.library.dto.SongResponseDTO;
import be.kunlabora.music.library.dto.UpdateSongDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            .map(SongResponseDTO::fromEntity)
            .toList();
    }

    @PostMapping
    public ResponseEntity<SongResponseDTO> createSong(@RequestBody CreateSongDTO dto) {
        var entity = new SongEntity(dto.title(), dto.artist(), dto.album(), dto.durationInSeconds());
        var saved = songRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(SongResponseDTO.fromEntity(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongResponseDTO> getSongById(@PathVariable UUID id) {
        return songRepository.findById(id)
            .map(entity -> ResponseEntity.ok(SongResponseDTO.fromEntity(entity)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongResponseDTO> updateSong(@PathVariable UUID id, @RequestBody UpdateSongDTO dto) {
        return songRepository.findById(id)
            .map(entity -> {
                entity.setTitle(dto.title());
                entity.setArtist(dto.artist());
                entity.setAlbum(dto.album());
                entity.setDurationInSeconds(dto.durationInSeconds());
                var updated = songRepository.save(entity);
                return ResponseEntity.ok(SongResponseDTO.fromEntity(updated));
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
}
