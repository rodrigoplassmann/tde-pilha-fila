public class Main {
    public static void main(String[] args) {

        FilaAtendimento fila = new FilaAtendimento();

        fila.adicionarCliente(new Elemento("Maria Silva", "CLI001", "Dúvida sobre produto", 0));
        fila.adicionarCliente(new Elemento("João Souza", "CLI002", "Reclamação de serviço", 0));
        fila.adicionarCliente(new Elemento("Ana Costa", "CLI003", "Solicitação de reembolso", 0));
        fila.adicionarCliente(new Elemento("Pedro Alves", "CLI004", "Informações de entrega", 0));
        fila.adicionarCliente(new Elemento("Carla Dias", "CLI005", "Agendamento de visita", 0));
        fila.adicionarCliente(new Elemento("Lucas Martins", "CLI006", "Alteração de pedido", 0));
        fila.adicionarCliente(new Elemento("Patrícia Rocha", "CLI007", "Cancelamento de contrato", 0));
        fila.adicionarCliente(new Elemento("Rafael Lima", "CLI008", "Renovação de assinatura", 0));
        fila.adicionarCliente(new Elemento("Fernanda Gomes", "CLI009", "Suporte para instalação", 0));
        fila.adicionarCliente(new Elemento("Carlos Eduardo", "CLI010", "Pedido de orçamento", 0));

        System.out.println("Fila (inicial):");
        fila.imprime();

        int atendimento = 1;
        while (!fila.vazia()) {
            System.out.println("\n--- Atendimento #" + atendimento + " ---");
            System.out.println("Fila (antes):");
            fila.imprime();

            Elemento atendido = fila.remove();
            if (atendido != null) {
                System.out.println("Atendido: " + atendido.getIdCliente() + " - " + atendido.getNomeCliente()
                        + " | Motivo: " + atendido.getMotivoAtendimento());
            }

            System.out.println("Fila (depois):");
            fila.imprime();
            atendimento = atendimento + 1;
        }

        System.out.println("\nFila esvaziada.");

        PilhaSolicitacoes pilha = new PilhaSolicitacoes();

        pilha.adicionaSolicitacao(new Elemento("REQ001", "Instalação de software", "2024-08-20 10:30"));
        pilha.adicionaSolicitacao(new Elemento("REQ002", "Manutenção preventiva", "2024-08-20 11:00"));
        pilha.adicionaSolicitacao(new Elemento("REQ003", "Atualização de sistema", "2024-08-20 11:30"));
        pilha.adicionaSolicitacao(new Elemento("REQ004", "Suporte técnico", "2024-08-20 12:00"));
        pilha.adicionaSolicitacao(new Elemento("REQ005", "Troca de equipamento", "2024-08-20 12:30"));
        pilha.adicionaSolicitacao(new Elemento("REQ006", "Consulta de garantia", "2024-08-20 13:00"));
        pilha.adicionaSolicitacao(new Elemento("REQ007", "Reparo de impressora", "2024-08-20 13:30"));
        pilha.adicionaSolicitacao(new Elemento("REQ008", "Configuração de rede", "2024-08-20 14:00"));
        pilha.adicionaSolicitacao(new Elemento("REQ009", "Restauração de dados", "2024-08-20 14:30"));
        pilha.adicionaSolicitacao(new Elemento("REQ010", "Consulta técnica", "2024-08-20 15:00"));

        System.out.println("\nHistórico:");
        pilha.exibeHistorico();
    }
}
