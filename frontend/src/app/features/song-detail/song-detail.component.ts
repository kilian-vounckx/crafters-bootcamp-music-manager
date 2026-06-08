import {Component, computed, inject} from '@angular/core';
import {SongService} from '../../core/services/song.service';
import {toObservable, toSignal} from '@angular/core/rxjs-interop';
import {ActivatedRoute, Router} from '@angular/router';
import {switchMap} from 'rxjs';

@Component({
  selector: 'song-detail',
  templateUrl: 'song-detail.component.html',
  styleUrl: 'song-detail.component.css',
})
export class SongDetailComponent {
  protected Math = Math;

  private router = inject(Router);
  private activatedRoute = inject(ActivatedRoute);
  private songService = inject(SongService);

  song = toSignal(
    this.activatedRoute.params.pipe(
      switchMap(params => this.songService.getSongById(params['id']))
    )
  )

  goBackToLibrary() {
    this.router.navigate(['songs']);
  }

  deleteSong() {
    this.songService.deleteSong(this.song()!.id).subscribe({next: () => this.goBackToLibrary()});
  }
}
