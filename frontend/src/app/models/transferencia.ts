export interface Transferencia {
  id: number;
  contaOrigem: string;
  contaDestino: string;
  valorTransferencia: number;
  taxa: number;
  dataTransferencia: string;
  dataAgendamento: string;
}