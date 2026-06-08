package be.kunlabora.music.library.dto;

import java.util.UUID;

public record SongResponseDTO(
    UUID id,
    String title,
    String artist,
    String album,
    int durationInSeconds
) {
}
