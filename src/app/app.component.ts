import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VentaService } from './services/ventas/venta.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  
  listaVentas: any[] = []
  fechaInicio: string = new Date().toLocaleDateString();
  fechaFin: string = new Date().toLocaleDateString();

  constructor(private fb: FormBuilder,
    private _ventaService: VentaService){
  }
  
  buscarVentas(){
    console.log(this.fechaInicio.toString());
    this._ventaService.listaVentas(this.fechaInicio, this.fechaFin).subscribe(data => {
      this.listaVentas = data;
    });
  }

  ngOnInit(): void {
  }
}