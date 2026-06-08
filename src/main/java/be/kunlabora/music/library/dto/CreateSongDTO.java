package be.kunlabora.music.library.dto;

public record CreateSongDTO(
    String title,
    String artist,
    String album,
    int durationInSeconds
){}
