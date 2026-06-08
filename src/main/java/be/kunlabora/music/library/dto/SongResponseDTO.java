package be.kunlabora.music.library.dto;

import be.kunlabora.music.library.SongEntity;

import java.util.UUID;

public record SongResponseDTO(
    UUID id,
    String title,
    String artist,
    String album,
    int durationInSeconds
) {
    public static SongResponseDTO fromEntity(SongEntity song) {
        return new SongResponseDTO(
            song.getId(),
            song.getTitle(),
            song.getArtist(),
            song.getAlbum(),
            song.getDurationInSeconds()
        );
    }
}
