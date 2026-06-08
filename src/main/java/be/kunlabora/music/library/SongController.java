package be.kunlabora.music.library;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/song")
public class SongController {
    SongRepository songRepository;

    SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @PostMapping
    UUID saveSong() {
        var song = songRepository.save(new SongEntity("titel", "artiest", "album", 42));
        return song.getId();
    }
}
