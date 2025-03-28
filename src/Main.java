import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite uma mensagem para iniciar:");
        scanner.nextLine(); // Mensagem inicial (não utilizada)

        while (true) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    menuPizza();
                    break;
                case 2:
                    formasDePagamento();
                    break;
                case 3:
                    tempoPreparoEntrega();
                    break;
                case 4:
                    localizacao();
                    break;
                case 5:
                    redesSociais();
                    break;
                case 6:
                    valores();
                    break;
                case 0:
                    System.out.println("Saindo do sistema... Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== Olá, bem-vindo à Pizzaria ForYou! =====");
        System.out.println("1: Menu Pizza");
        System.out.println("2: Formas de pagamento");
        System.out.println("3: Tempo de preparo e entrega");
        System.out.println("4: Onde estamos localizados");
        System.out.println("5: Nossas redes sociais");
        System.out.println("6: Consultar valores");
        System.out.println("0: Sair do sistema");
        System.out.print("Escolha uma opção: ");
        System.out.println("\n================================");
    }

    private static int lerOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número válido!");
            scanner.next();
        }
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer
        return opcao;
    }

    private static void menuPizza() {
        System.out.println("\n====== Menu Pizza ======");
        System.out.println("Pizzas normais:");
        System.out.println("N1: Calabresa");
        System.out.println("N2: Frango com Catupiry");
        System.out.println("N3: Quatro Queijos");
        System.out.println("Pizzas especiais:");
        System.out.println("E1: A Moda da Casa");
        System.out.println("E2: Baiana");
        System.out.println("E3: Portuguesa");

        System.out.print("Escolha um sabor: ");

        String pizzaSabor = scanner.nextLine();
        String PizzaEscolhida = switch (pizzaSabor) {
            case "N1" -> "Calabresa";
            case "N2" -> "Frango com Catupiry";
            case "N3" -> "Quatro Queijos";
            case "E1" -> "A moda da casa";
            case "E2" -> "Baiana";
            case "E3" -> "Portuguesa";
            default -> "INVÁLIDO";
        };

        if (PizzaEscolhida.equals("INVÁLIDO")) {
            System.out.println("Pizza inválida! Voltando ao menu principal.");
            return;
        }

        System.out.println("\nEscolha o tamanho da pizza:");
        System.out.println("1: P");
        System.out.println("2: M");
        System.out.println("3: G");
        System.out.println("4: GG");
        System.out.print("Escolha o tamanho: ");


        int tamanho = lerOpcao();
        String tamanhoEscolhido = switch (tamanho) {
            case 1 -> "P";
            case 2 -> "M";
            case 3 -> "G";
            case 4 -> "GG";
            default -> "INVÁLIDO";
        };

        if (tamanhoEscolhido.equals("INVÁLIDO")) {
            System.out.println("Tamanho inválido! Voltando ao menu principal.");
            return;
        }

        System.out.print("\nInforme o endereço de entrega: ");
        String endereco = scanner.nextLine();
        System.out.println("\n================================");
        System.out.println("\nPedido confirmado!");
        System.out.println("Pizza: " + PizzaEscolhida + " - " + tamanhoEscolhido);
        System.out.println("Endereço: " + endereco);
        System.out.println("Obrigado! O tempo de entrega é no máximo 30 minutos.");
        System.out.println("\n================================");
    }

    private static void formasDePagamento() {
        System.out.println("\nAceitamos as seguintes formas de pagamento:");
        System.out.println("Crédito, débito ou Pix.");
    }

    private static void tempoPreparoEntrega() {
        System.out.println("\n========= Tempo Aproximado =========");
        System.out.println("O tempo de preparo é de até 30 minutos,");
        System.out.println("mais 30 minutos de tempo de entrega, dependendo da sua localidade.");
    }

    private static void localizacao() {
        System.out.println("\n========== Nosso endereço: ==========");
        System.out.println("Rua Dom jõao XI, N 01, Zona Leste - Arapucas.");
    }

    private static void redesSociais() {
        System.out.println("\n======== Nossas redes sociais: ========");
        System.out.println("Facebook: www.facebook.com/pizzaforyou");
        System.out.println("Instagram: @pizzaforyou");
        System.out.println("Siga-nos para receber promoções e descontos exclusivos.");
    }

    private static void valores() {
        System.out.println("Os valores das pizzas são: ");
        System.out.println("=====Pizzas normais=====");
        System.out.println("Tamanho:\n" +
                "P - R$20,00\n" +
                "M - R$30,00\n" +
                "G - R$40,00\n" +
                "GG - R$50,00");
        System.out.println("=====Pizzas especiais=====");
        System.out.println("Tamanho:\n" +
                "P - R$30,00\n" +
                "M - R$40,00\n" +
                "G - R$50,00\n" +
                "GG - R$60,00");
    }
}