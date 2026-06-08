import {Component, computed, inject} from '@angular/core'
import {SongService} from '../../core/services/song.service';
import {toSignal} from '@angular/core/rxjs-interop';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'song-list',
  templateUrl: 'song-list.component.html',
  styleUrl: 'song-list.component.css',
  imports: [
    RouterLink
  ]
})
export class SongListComponent {
  protected readonly Math = Math;

  private songService = inject(SongService)
  songs = toSignal(this.songService.getSongs(), {initialValue: []})
  nrOfSongs = computed(() => this.songs().length)
}
