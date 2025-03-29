import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite uma mensagem para iniciar:");
        scanner.nextLine(); // Mensagem inicial (não utilizada)

        while (true) {
            exibirMenuPrincipal();
            int opcao = lerOpcao(0, 6);

            switch (opcao) {
                case 1 -> menuPizza();
                case 2 -> formasDePagamento();
                case 3 -> tempoPreparoEntrega();
                case 4 -> localizacao();
                case 5 -> redesSociais();
                case 6 -> exibirValores();
                case 0 -> {
                    System.out.println("Saindo do sistema... Até logo!");
                    scanner.close();
                    return;
                }
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

    private static int lerOpcao(int min, int max) {
        int opcao;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido!");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer
            if (opcao >= min && opcao <= max) {
                return opcao;
            }
            System.out.println("Opção inválida! Escolha um número entre " + min + " e " + max + ".");
        }
    }

    private static void menuPizza() {
        System.out.println("\n====== Menu Pizza ======");
        System.out.println("1: Calabresa");
        System.out.println("2: Frango com Catupiry");
        System.out.println("3: Quatro Queijos");
        System.out.println("4: A moda da casa");
        System.out.println("5: Baiana");
        System.out.println("6: Portuguesa");
        System.out.println("0: Cancelar");
        System.out.print("Escolha um sabor: ");

        int pizzaSabor = lerOpcao(0, 6);
        if (pizzaSabor == 0) {
            System.out.println("Pedido cancelado! Voltando ao menu principal.");
            return;
        }
        String[] pizzas = {"Calabresa", "Frango com Catupiry", "Quatro Queijos", "A moda da casa", "Baiana", "Portuguesa"};
        String pizzaEscolhida = pizzas[pizzaSabor - 1];




        System.out.println("\nEscolha o tamanho da pizza:");
        System.out.println("1: P");
        System.out.println("2: M");
        System.out.println("3: G");
        System.out.println("4: GG");
        System.out.println("0: Cancelar");
        System.out.print("Escolha o tamanho: ");

        int tamanho = lerOpcao(0, 4);
        if (tamanho == 0) {
            System.out.println("Pedido cancelado! Voltando ao menu principal.");
            return;
        }

        String[] tamanhos = {"P", "M", "G", "GG"};
        String tamanhoEscolhido = tamanhos[tamanho - 1];


        System.out.print("\nInforme o endereço de entrega: ");
        String endereco = scanner.nextLine();


        System.out.println("\nEscolha a Forma de Pagamento:");
        System.out.println("1: Cartão de Crédito");
        System.out.println("2: Cartão de Débito");
        System.out.println("3: Pix");
        System.out.println("4: Dinheiro");
        System.out.println("0: Cancelar");
        System.out.print("Forma de Pagamento: ");

        int pagamento = lerOpcao(0, 4);
        if (pagamento == 0) {
            System.out.println("Pedido cancelado! Voltando ao menu principal.");
            return;
        }
        if (pagamento == 4) {
            System.out.println("Precisa de troco?");
            System.out.println("1: Sim");
            System.out.println("2: Não");
//            String  = scanner.nextLine();
        }
        // Parei aqui

        String[] pagamentos = {"Cartão de Crédito","Cartão de Débito","Pix", "Dinheiro"};
        String pagamentoEscolhido = pagamentos[pagamento - 1];

        System.out.println("\n================================");
        System.out.println("\nPedido confirmado!");
        System.out.println("Pizza: " + pizzaEscolhida + " - " + tamanhoEscolhido);
        System.out.println("Endereço: " + endereco);
        System.out.println("Forma de Pagamento: " + pagamentoEscolhido + " - ");
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
        System.out.println("Rua Dom João XI, N 01, Zona Leste - Arapucas.");
    }

    private static void redesSociais() {
        System.out.println("\n======== Nossas redes sociais: ========");
        System.out.println("Facebook: www.facebook.com/pizzaforyou");
        System.out.println("Instagram: @pizzaforyou");
        System.out.println("Siga-nos para receber promoções e descontos exclusivos.");
    }

    private static void exibirValores() {
        System.out.println("Os valores das pizzas são: ");
        System.out.println("=====Pizzas normais=====");
        exibirPrecoPizza(20, 30, 40, 50);
        System.out.println("=====Pizzas especiais=====");
        exibirPrecoPizza(30, 40, 50, 60);
    }

    private static void exibirPrecoPizza(int p, int m, int g, int gg) {
        System.out.println("Tamanho:\n" +
                "P - R$" + p + ",00\n" +
                "M - R$" + m + ",00\n" +
                "G - R$" + g + ",00\n" +
                "GG - R$" + gg + ",00");
    }
}