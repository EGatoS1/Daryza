import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Linea, LineaRequest } from '../../Models/Linea';
import { LineaService } from '../../Services/linea.service';
import { TablesComponent } from '../../components/tables/tables.component';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-registrar-linea',
  standalone: true,
  imports: [FormsModule, CommonModule,TablesComponent],
  templateUrl: './registrar-linea.component.html',
  styleUrl: './registrar-linea.component.css',
})
export class RegistrarLineaComponent implements OnInit {
  Lineas: Linea[] = [];
  lineaService = inject(LineaService);
  NewLinea: LineaRequest = { nombre: '' };
  nombreVacio: boolean = false;

  ngOnInit(): void {
    this.cargarLineas();
  }

  cargarLineas() {
    this.lineaService.listar().subscribe((data) => {
      this.Lineas = data;
    });
  }

  private esNombreValido(nombre: string): boolean {
    return !!nombre && nombre.trim().length > 0;
  }

  private resetFormulario() {
    this.NewLinea = { nombre: '' };
  }

  Registrar() {
    if (!this.esNombreValido(this.NewLinea.nombre)) {
      this.nombreVacio = true;
      return;
    }

    this.nombreVacio = false;

    this.lineaService.create(this.NewLinea).subscribe(() => {
      this.resetFormulario();
      this.cargarLineas();
    });
  }
}
