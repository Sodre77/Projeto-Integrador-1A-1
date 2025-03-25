import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String msg;
        int opc;
        int subOpc; // Variável para o sub-menu de tamanhos
        String enderecoEntrega; // Para armazenar o endereço do usuário

        System.out.println("Digite uma mensagem para iniciar:");
        msg = scanner.nextLine(); // Mensagem inicial qualquer

        do {
            // Exibe o menu principal
            System.out.println("\n===== Olá, bem vindo a pizzaria ForYou! ======");
            System.out.println("");
            System.out.println("Escolha uma opção:");
            System.out.println("");
            System.out.println("1 : Menu Pizza");
            System.out.println("2 : Formas de pagamento");
            System.out.println("3 : Tempo, preparo e entrega");
            System.out.println("4 : Onde estamos localizados");
            System.out.println("5 : Nossas redes sociais");
            System.out.println("0 : Sair do sistema");

            // Lê a opção do usuário
            opc = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do Enter após o nextInt()

            switch (opc) {
                case 1:
                    System.out.println("====== Menu Pizza ======");
                    System.out.println("1: Calabresa");
                    System.out.println("2: Frango com catupiry");
                    System.out.println("3: Quatro Queijos");
                    System.out.println("4: A moda da casa");

                    // Lê a opção do usuário
                    opc = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do Enter após o nextInt()

                    // Sub-menu de tamanhos
                    System.out.println("\nEscolha o tamanho da pizza:");
                    System.out.println("1: Pequena");
                    System.out.println("2: Média");
                    System.out.println("3: Grande");
                    System.out.println("4: Família");

                    subOpc = scanner.nextInt();
                    scanner.nextLine(); // Limpa o Enter

                    // Confirmação do pedido
                    switch (subOpc) {
                        case 1:
                            System.out.println("Você escolheu pizza tamanho PEQUENA.");
                            break;
                        case 2:
                            System.out.println("Você escolheu pizza tamanho MÉDIA.");
                            break;
                        case 3:
                            System.out.println("Você escolheu pizza tamanho GRANDE.");
                            break;
                        case 4:
                            System.out.println("Você escolheu pizza tamanho FAMÍLIA.");
                            break;
                        default:
                            System.out.println("Opção de tamanho inválida.");
                            break;

                    }

                    // Solicita o endereço de entrega
                    System.out.println("\nInforme o endereço de entrega:");
                    enderecoEntrega = scanner.nextLine();

                    // Exibe mensagem final do pedido
                    System.out.println("\nPedido confirmado!");
                    System.out.println("Endereço informado: " + enderecoEntrega);
                    System.out.println("Obrigado! O tempo de entrega é no máximo 30 minutos.");

                    // Aguarda interação para voltar ao menu
                    System.out.println("\nPressione ENTER para voltar ao menu.");
                    scanner.nextLine(); // Aguarda interação para voltar
                    break;

                case 2:
                    System.out.println("Aceitamos cartões de:");
                    System.out.println("Crédito, débito ou Pix.");
                    System.out.println("\nPressione ENTER para voltar ao menu.");
                    scanner.nextLine(); // Aguarda interação para voltar
                    break;

                case 3:
                    System.out.println("========= Tempo Aproximado =========");
                    System.out.println("O tempo de preparo é no máximo 30 minutos.");
                    System.out.println("O tempo de entrega é de 30 minutos, dependendo da sua localidade.");
                    System.out.println("\nPressione ENTER para voltar ao menu.");
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("========== Nosso endereço é:==========.");
                    System.out.println("Estamos localizados na Rua 04, N 01, St. Central - Goiânia.");
                    System.out.println("\nPressione ENTER para voltar ao menu.");
                    scanner.nextLine();
                    break;

                case 5:
                    System.out.println("========Nossas redes sociais são:========");
                    System.out.println("Facebook:www.facebook.com/pizzaforyou");
                    System.out.println("Instagram: @pizzaforyou");
                    System.out.println("Siga-nos para receber promoções e descontos exclusivos.");
                    System.out.println("\nPressione ENTER para voltar ao menu.");
                    scanner.nextLine();
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    System.out.println("\nPressione ENTER para voltar ao menu.");
                    scanner.nextLine();
                    break;
            }

        } while (opc != 0);

        scanner.close();
    }
}