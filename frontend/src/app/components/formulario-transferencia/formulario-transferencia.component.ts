import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TransferenciaRequest } from '../../models/transferencia-request';
import { TransferenciaService } from '../../services/transferencia.service';

@Component({
    selector: 'app-formulario-transferencia',
    standalone: true,
    imports: [FormsModule, CommonModule],
    templateUrl: './formulario-transferencia.component.html',
    styleUrl: './formulario-transferencia.component.css'
})
export class FormularioTransferenciaComponent {

    @Output() transferenciaCriada = new EventEmitter<void>();

    transferencia: TransferenciaRequest = {
        contaOrigem: '',
        contaDestino: '',
        valorTransferencia: 0,
        dataTransferencia: ''
    };

    mensagemSucesso = '';
    mensagemErro = '';

    constructor(private transferenciaService: TransferenciaService) { }

    agendar(): void {
        this.mensagemSucesso = '';
        this.mensagemErro = '';

        this.transferenciaService.agendar(this.transferencia).subscribe({
            next: () => {
                this.mensagemSucesso = 'Transferência agendada com sucesso!';
                this.transferenciaCriada.emit();
                this.limparFormulario();
            },
            error: (erro) => {
                console.log(erro);
                this.mensagemErro = erro.error?.mensagem || erro.message || 'Erro ao agendar transferência.';
            }
        });
    }

    private limparFormulario(): void {
        this.transferencia = {
            contaOrigem: '',
            contaDestino: '',
            valorTransferencia: 0,
            dataTransferencia: ''
        };
    }
}