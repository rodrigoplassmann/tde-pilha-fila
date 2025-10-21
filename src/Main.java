import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaSolicitacoes pilha = new PilhaSolicitacoes();
        FilaAtendimento fila = new FilaAtendimento();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("1 - Adicionar cliente na fila");
            System.out.println("2 - Atender próximo cliente");
            System.out.println("3 - Mostrar fila");
            System.out.println("4 - Adicionar solicitação no histórico (pilha)");
            System.out.println("5 - Remover última solicitação (desfazer)");
            System.out.println("6 - Mostrar histórico");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do cliente: ");
                String nome = sc.nextLine();
                System.out.print("Motivo do atendimento: ");
                String motivo = sc.nextLine();

                Elemento cliente = new Elemento(nome, motivo, 1);
                fila.adicionarCliente(cliente);
                System.out.println("Cliente adicionado à fila");
            }
            else if (opcao == 2) {
                Elemento atendido = fila.remove();
                if (atendido != null) {
                    System.out.println("Cliente atendido: " + atendido.getNomeCliente());
                }
            }
            else if (opcao == 3) {
                if (fila.vazia()) {
                    System.out.println("Fila vazia!");
                } else {
                    System.out.println("Fila atual:");
                    fila.imprime();
                }
            }
            else if (opcao == 4) {
                System.out.print("Descrição da solicitação: ");
                String desc = sc.nextLine();
                System.out.print("Data e hora (DD-MM-YYYY HH:MM): ");
                String dataHora = sc.nextLine();

                Elemento solicitacao = new Elemento(desc, dataHora);
                pilha.adicionaSolicitacao(solicitacao);
                System.out.println("Solicitação adicionada ao histórico");
            }
            else if (opcao == 5) {
                Elemento removida = pilha.removeSolicitacao();
                if (removida != null) {
                    System.out.println("Solicitação removida: " + removida.getDescricaoSolicitacao());
                }
            }
            else if (opcao == 6) {
                System.out.println("Histórico de solicitações:");
                pilha.exibeHistorico();
            }
            else if (opcao == 0) {
                System.out.println("Encerrando o sistema...");
            }
            else {
                System.out.println("Opção inválida! Escolha uma opção de 0 a 6.");
            }
        }

        sc.close();
    }
}
