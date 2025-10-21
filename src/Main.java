import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilhaSolicitacoes pilha = new PilhaSolicitacoes();
        FilaAtendimento fila = new FilaAtendimento();

        int opcao = -1;

        while (opcao != 0) {
            try {
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
            }
            catch (Exception e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                sc.nextLine(); // limpa entrada inválida
                opcao = -1;
                continue;
            }

            if (opcao == 1) {
                try {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    if (nome.length() == 0) {
                        throw new Exception("O nome não pode estar vazio!");
                    }

                    System.out.print("Motivo do atendimento: ");
                    String motivo = sc.nextLine();
                    if (motivo.length() == 0) {
                        throw new Exception("O motivo não pode estar vazio!");
                    }

                    Elemento cliente = new Elemento(nome, motivo, 1);
                    fila.adicionarCliente(cliente);
                    System.out.println("Cliente adicionado à fila");
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
                try {
                    System.out.print("Descrição da solicitação: ");
                    String desc = sc.nextLine();
                    if (desc.length() == 0) {
                        throw new Exception("A descrição não pode estar vazia!");
                    }

                    System.out.print("Data e hora (DD-MM-YYYY HH:MM): ");
                    String dataHora = sc.nextLine();

                    if (dataHora.length() != 16) {
                        throw new Exception("Formato incorreto! Use DD-MM-YYYY HH:MM");
                    }

                    if (dataHora.charAt(2) != '-' || dataHora.charAt(5) != '-' ||
                            dataHora.charAt(10) != ' ' || dataHora.charAt(13) != ':') {
                        throw new Exception("Formato incorreto! Use DD-MM-YYYY HH:MM");
                    }

                    Elemento solicitacao = new Elemento(desc, dataHora);
                    pilha.adicionaSolicitacao(solicitacao);
                    System.out.println("Solicitação adicionada ao histórico");
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
