package be.kunlabora.music.library;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SongRepository extends CrudRepository<SongEntity, UUID> {
    @Override
    List<SongEntity> findAll();
}
