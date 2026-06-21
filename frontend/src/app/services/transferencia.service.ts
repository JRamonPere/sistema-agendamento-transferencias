import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transferencia } from '../models/transferencia';
import { TransferenciaRequest } from '../models/transferencia-request';

@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {

  private readonly apiUrl = 'http://localhost:8080/transferencias';

  constructor(private http: HttpClient) { }

  agendar(request: TransferenciaRequest): Observable<Transferencia> {
    return this.http.post<Transferencia>(this.apiUrl, request);
  }

  listar(): Observable<Transferencia[]> {
    return this.http.get<Transferencia[]>(this.apiUrl);
  }
}