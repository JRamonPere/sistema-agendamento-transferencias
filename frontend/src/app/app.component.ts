import { Component, ViewChild } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormularioTransferenciaComponent } from './components/formulario-transferencia/formulario-transferencia.component';
import { ListaTransferenciasComponent } from './components/lista-transferencias/lista-transferencias.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    FormularioTransferenciaComponent,
    ListaTransferenciasComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  @ViewChild(ListaTransferenciasComponent)
  listaTransferenciasComponent!: ListaTransferenciasComponent;

  atualizarLista(): void {
    this.listaTransferenciasComponent.carregarTransferencias();
  }
}