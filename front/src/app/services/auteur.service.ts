import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuteurModel} from '../models/auteur.model';

@Injectable({
  providedIn: 'root',
})

export class AuteurService {
  private apiUrl = 'api/auteur';

  constructor(private httpClient: HttpClient) {
  }

  public getAllAuteurs(): Observable<AuteurModel[]> {
    return this.httpClient.get<AuteurModel[]>(`${this.apiUrl}/allAuteurs`);
  }

  public insertAuteur(auteurInfo: AuteurModel): Observable<AuteurModel> {
    return this.httpClient.post<AuteurModel>(`${this.apiUrl}/insertAuteur`, auteurInfo);
  }
}
