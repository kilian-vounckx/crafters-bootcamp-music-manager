package be.kunlabora.music.library.dto;

public record UpdateSongDTO(
    String title,
    String artist,
    String album,
    int durationInSeconds
) {}
