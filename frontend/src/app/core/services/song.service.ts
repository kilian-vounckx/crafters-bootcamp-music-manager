import {inject, Injectable} from '@angular/core'
import {HttpClient} from '@angular/common/http';
import {Song} from '../types/song.types';
import {Observable} from 'rxjs';

@Injectable({providedIn: 'root'})
export class SongService {
  private http = inject(HttpClient)
  private apiBaseUrl = 'http://localhost:8080'

  getSongs(): Observable<Song[]> {
    return this.http.get<Song[]>(`${this.apiBaseUrl}/api/song`);
  }

  getSongById(id: string): Observable<Song> {
    return this.http.get<Song>(`${this.apiBaseUrl}/api/song/${id}`);
  }

  deleteSong(id: string): Observable<Object> {
    return this.http.delete(`${this.apiBaseUrl}/api/song/${id}`)
  }
}
