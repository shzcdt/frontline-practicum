import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UnitService {
  private apiUrl = 'http://localhost:8081/api/units';
  constructor(private http: HttpClient) {}
  moveUnit(unitId: number, q: number, r: number): Observable<string> {
    return this.http.post(`${this.apiUrl}/${unitId}/move`, null, {
      params: { q: q.toString(), r: r.toString() },
      responseType: 'text'
    });
  }
}
