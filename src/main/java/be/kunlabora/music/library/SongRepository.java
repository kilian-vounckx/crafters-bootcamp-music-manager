package be.kunlabora.music.library;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SongRepository extends CrudRepository<SongEntity, UUID> {
    SongEntity findSongEntityByTitle(String title);
}
