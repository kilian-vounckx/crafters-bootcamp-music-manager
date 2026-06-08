export type Song = {
  id: string
  title: string
  artist: string
  album: string
  durationInSeconds: number
}

export type CreateUpdateSong = Omit<Song, 'id'>
