import {Injectable} from '@angular/core';
import {LivreModel} from '../models/livre.model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class LivreService {
  private apiUrl = 'api/livre';

  constructor(private httpClient: HttpClient) {
  }

  public getAllLivres(): Observable<LivreModel[]> {
    return this.httpClient.get<LivreModel[]>(`${this.apiUrl}/allLivres`);
  }

  public insertLivre(livreInfo: LivreModel): Observable<LivreModel> {
    return this.httpClient.post<LivreModel>(`${this.apiUrl}/insertLivre`, livreInfo);
  }
}
