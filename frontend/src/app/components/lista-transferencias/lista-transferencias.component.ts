import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Transferencia } from '../../models/transferencia';
import { TransferenciaService } from '../../services/transferencia.service';

@Component({
  selector: 'app-lista-transferencias',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-transferencias.component.html',
  styleUrl: './lista-transferencias.component.css'
})
export class ListaTransferenciasComponent implements OnInit {

  transferencias: Transferencia[] = [];

  constructor(private transferenciaService: TransferenciaService) { }

  ngOnInit(): void {
    this.carregarTransferencias();
  }

  carregarTransferencias(): void {
    this.transferenciaService.listar().subscribe({
      next: (dados) => {
        this.transferencias = dados;
      }
    });
  }
}