import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VentaService {

  myAppUrl = 'http://localhost:8049/venta/';
  constructor(private http: HttpClient){}

  listaVentas(fechaInicio: string, fechaFin: string): Observable<any>{
      console.log(this.myAppUrl + 'obtener-fechas?fechaInicio='+ fechaInicio +'&fechaFin='+ fechaFin);
      return this.http.get(this.myAppUrl + 'obtener-fechas?fechaInicio='+ fechaInicio +'&fechaFin='+ fechaFin);
  }
}
