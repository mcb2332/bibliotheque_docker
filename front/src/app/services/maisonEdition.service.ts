import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {MaisonEditionModel} from '../models/maisonEdition.model';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})

export class MaisonEditionService {
  private apiUrl = 'api/maisonEdition';

  constructor(private httpClient: HttpClient) {
  }

  public getAllMaisonsEdition(): Observable<MaisonEditionModel[]> {
    return this.httpClient.get<MaisonEditionModel[]>(`${this.apiUrl}/allMaisonsEdition`);
  }

  public insertMaisonEdition(maisonEditionInfo: MaisonEditionModel): Observable<MaisonEditionModel> {
    return this.httpClient.post<MaisonEditionModel>(`${this.apiUrl}/insertMaisonEdition`, maisonEditionInfo)
  }
}
