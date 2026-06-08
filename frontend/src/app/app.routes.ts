import { Routes } from '@angular/router';
import {SongListComponent} from './features/song-list/song-list.component';
import {SongDetailComponent} from './features/song-detail/song-detail.component';
import {SongFormComponent} from './features/song-form/song-form.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'songs',
    pathMatch: 'full'
  },
  {
    path: 'songs',
    component: SongListComponent
  },
  {
    path: 'songs/:id',
    component: SongDetailComponent
  },
  {
    path: 'songs/add',
    component: SongFormComponent
  },
  {
    path: 'songs/:id/edit',
    component: SongFormComponent
  }
];
