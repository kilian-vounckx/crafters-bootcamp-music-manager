create table if not exists songs (
    id Uuid primary key not null,
    title Text not null,
    artist Text not null,
    album Text not null,
    duration_in_seconds Int not null
);