public class Main {
    public static void main(String[] args) {

        FilaAtendimento fila = new FilaAtendimento();

        fila.adicionarCliente(new Elemento("Maria Silva", "CLI001", "Dúvida sobre produto", 0));
        fila.adicionarCliente(new Elemento("João Souza", "CLI002", "Reclamação de serviço", 0));
        fila.adicionarCliente(new Elemento("Ana Costa", "CLI003", "Solicitação de reembolso", 0));

        System.out.println("Fila (ordem atual):");
        fila.imprime();

        System.out.println("\nAtendendo o próximo cliente...");
        Elemento atendido = fila.remove();
        if (atendido != null) {
            System.out.println("Atendido: " + atendido.getIdCliente() + " - " + atendido.getNomeCliente());
        }

        System.out.println("\nFila (após 1 atendimento):");
        fila.imprime();

        PilhaSolicitacoes pilha = new PilhaSolicitacoes();

        pilha.adicionaSolicitacao(new Elemento("REQ001", "Instalação de software", "2024-08-20 10:30"));
        pilha.adicionaSolicitacao(new Elemento("REQ002", "Manutenção preventiva", "2024-08-20 11:00"));
        pilha.adicionaSolicitacao(new Elemento("REQ003", "Atualização de sistema", "2024-08-20 11:30"));

        System.out.println("\nHistórico:");
        pilha.exibeHistorico();

        System.out.println("\nRemovendo última solicitação do histórico...");
        Elemento removida = pilha.removeSolicitacao();
        if (removida != null) {
            System.out.println("Removida: " + removida.getIdSolicitacao() + " - " + removida.getDescricaoSolicitacao());
        }

        System.out.println("\nHistórico (após 1 remoção):");
        pilha.exibeHistorico();
    }
}
