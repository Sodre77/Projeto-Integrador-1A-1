import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public static Cardapio cardapio = new Cardapio();

    public static void main(String[] args) {
        System.out.println("Pressione ENTER para iniciar:");
        scanner.nextLine(); // Mensagem inicial
        criarCardapio();

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
        System.out.println("\n=============================================");
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
        System.out.println("=====Pizzas Normais=====");
        int item = 0;
        while (item < cardapio.normais.size()) {
            System.out.println((item+1) + " - " + cardapio.normais.get(item));
            item++;
        }
        System.out.println("=====Pizzas Especiais=====");
        while ((item - cardapio.normais.size()) < cardapio.especiais.size()) {
            System.out.println((item+1) + " - " + cardapio.especiais.get(item - cardapio.normais.size()));
            item++;
        }
        System.out.println("\n0 - Cancelar pedido");
        System.out.println("\n========================");
        int quantidadeNormal = cardapio.normais.size();

        System.out.print("Escolha um sabor: ");
        int pizzaSabor = lerOpcao(0, (item));

        String pizzaEscolhida = "";
        if (pizzaSabor == 0) {
            System.out.println("Pedido cancelado! Voltando ao menu principal.");
            return;
        }
        boolean especial = false;
        if (pizzaSabor > cardapio.normais.size()) {
            pizzaEscolhida = cardapio.especiais.get(pizzaSabor - quantidadeNormal - 1);
            especial = true;
        } else {
            pizzaEscolhida = cardapio.normais.get(pizzaSabor - 1);
            especial = false;
        }

        System.out.println("\n========== Escolha o tamanho da pizza: ==========");
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

        System.out.println("=============================");
        int bebida;
        String bebidaEscolhida = "Não optou por bebida";
        System.out.println("Deseja uma bebida?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        bebida = scanner.nextInt();
        if (bebida == 1) {
            bebidaEscolhida = menuBebida();
        }

        System.out.print("\nInforme o endereço de entrega: ");
        String endereco = scanner.nextLine();


        System.out.println("\n========== Escolha a Forma de Pagamento: ==========");
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

        String bandeiraCartao = "";
        if(pagamento == 1) {
            System.out.println("========== Digite a Bandeira do Cartão: ==========");
            System.out.println("1: Mastercard");
            System.out.println("2: Elo");
            System.out.println("3: Visa");
            System.out.println("4: HiperCard");
            int opcaoBandeira  = lerOpcao(1, 4);

            String[] bandeiras = {"Mastercard", "Elo", "Visa", "HiperCard"};
            bandeiraCartao = " - " + bandeiras[opcaoBandeira - 1];
        }
        if (pagamento == 4 ) {
            System.out.println("========== Precisa de troco? ==========");
            System.out.println("1: Sim");
            System.out.println("2: Não");
            int precisaTroco = lerOpcao(1, 2);
                if (precisaTroco == 1) {
                    System.out.print("Digite o valor para o troco: R$ ");
                    double valorEntregue = scanner.nextDouble();
                    scanner.nextLine(); // limpar buffer
                    double troco = valorEntregue - obterPrecoPizza(tamanhoEscolhido, pizzaEscolhida);
                    System.out.println("Seu troco será de: R$" + troco);
                }
        }

        String[] pagamentos = {"Cartão de Crédito","Cartão de Débito","Pix", "Dinheiro"};
        String pagamentoEscolhido = pagamentos[pagamento - 1];

        System.out.println("\n============== Pedido Confirmado!=============");
        System.out.println("Pizza: " + pizzaEscolhida + " - " + tamanhoEscolhido);
        System.out.println("Bebida: " + bebidaEscolhida);
        System.out.println("Endereço: " + endereco);
        System.out.println("Forma de Pagamento: " + pagamentoEscolhido
                + bandeiraCartao );
        System.out.println("Obrigado! O tempo de entrega é no máximo 30 minutos.");
        System.out.println("\n=============================================");
        System.out.println("Pressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
    }

    private static String menuBebida() {
        String bebida = "";
        System.out.println("======================");
        System.out.println("\nO que você deseja?");
        System.out.println("1 - Refrigerantes");
        System.out.println("2 - Sucos");
        System.out.println("3 - Água");
        System.out.println("0 - Cancelar");
        System.out.print("\nDigite sua escolha: ");
        int bebidaEscolhida = lerOpcao(0, 3);
        switch (bebidaEscolhida) {
            case 1:
                System.out.println("=====Escolha seu refrigerante=====");
                int refri = 0;
                while (refri < cardapio.refrigerantes.size()) {
                    System.out.println((refri + 1) + " - " + cardapio.refrigerantes.get(refri));
                    refri++;
                }
                System.out.println("=====Digite sua resposta=====");
                int refriEscolhido = lerOpcao(0, refri);

                if (refriEscolhido == 0) {
                    break;
                } else {
                    bebida = cardapio.refrigerantes.get(refriEscolhido - 1);
                }
                break;
            case 2:
                System.out.println("=====Escolha o sabor do seu suco=====");
                int suco = 0;
                while (suco < cardapio.sucos.size()) {
                    System.out.println((suco + 1) + " - " + cardapio.sucos.get(suco));
                    suco++;
                }
                System.out.println("=====Digite sua resposta=====");
                int sucoEscolhido = lerOpcao(0, suco);
                if (sucoEscolhido == 0) {
                    break;
                } else {
                    bebida = cardapio.refrigerantes.get(sucoEscolhido - 1);
                }
                break;
            case 3:
                bebida = "Água";
                break;
            case 0:
                break;
        }
        System.out.println("Qual será o tamanho da bebida?");
        System.out.println("1 - 200ml");
        System.out.println("2 - 500ml");
        System.out.println("3 - 1L");
        System.out.println("4 - 2L");
        System.out.print("digite sua resposta");
        int tamanho = lerOpcao(1, 4);
        String[] tamanhos = {"200ml", "500ml", "1L", "2L"};
        String tamanhoEscolhido = tamanhos[tamanho - 1];
        bebida = bebida + " - " + tamanhoEscolhido;
        return bebida;
    }

    private static double obterPrecoPizza(String tamanho, String pizza) {
        boolean isEspecial = cardapio.especiais.contains(pizza);
        Map<String, Integer> precos = isEspecial
                ? Map.of("P", 30, "M", 40, "G", 50, "GG", 60)
                : Map.of("P", 20, "M", 30, "G", 40, "GG", 50);

        return precos.getOrDefault(tamanho, 0);
    }

    private static void formasDePagamento() {
        System.out.println("\n============ Tipos de Pagamentos ============");
        System.out.println("Crédito, débito, Dinheiro e Pix.");
        System.out.println("\n=============================================");
        System.out.println("Pressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
    }

    private static void tempoPreparoEntrega() {
        System.out.println("\n============= Tempo Aproximado ==============");
        System.out.println("O tempo de preparo é de até 30 minutos,");
        System.out.println("mais 30 minutos de tempo de entrega, dependendo da sua localidade.");
        System.out.println("\n=============================================");
        System.out.println("Pressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
    }

    private static void localizacao() {
        System.out.println("\n============== Nosso endereço: ==============");
        System.out.println("Rua Dom João XI, N 01, Zona Leste - Arapucas.");
        System.out.println("\n=============================================");
        System.out.println("Pressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
    }

    private static void redesSociais() {
        System.out.println("\n============ Nossas redes sociais: ===========");
        System.out.println("Facebook: www.facebook.com/pizzaforyou");
        System.out.println("Instagram: @pizzaforyou");
        System.out.println("Siga-nos para receber promoções e descontos exclusivos.");
        System.out.println("\n=============================================");
        System.out.println("Pressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
    }

    private static void exibirValores() {
        System.out.println("\n======= Valor das Pizzas =======");
        System.out.println("=====Pizzas normais=====");
        exibirPrecoPizza(20, 30, 40, 50);
        System.out.println("=====Pizzas especiais=====");
        exibirPrecoPizza(30, 40, 50, 60);
        System.out.println("Pressione ENTER para voltar ao menu principal.");
        scanner.nextLine();
    }

    private static void exibirPrecoPizza(int p, int m, int g, int gg) {
        System.out.println("Tamanho:\n" +
                "P - R$" + p + ",00\n" +
                "M - R$" + m + ",00\n" +
                "G - R$" + g + ",00\n" +
                "GG - R$" + gg + ",00");
        System.out.println("\n=============================================");
    }

    private static void criarCardapio() {
        //Adicionar Pizzas normais
        cardapio.addNormal("Calabresa");
        cardapio.addNormal("Frango com Catupiry");
        cardapio.addNormal("Quatro Queijos");

        //Adicionar Pizzas especiais
        cardapio.addEspecial("A moda da casa");
        cardapio.addEspecial("Baiana");
        cardapio.addEspecial("Portuguesa");

        //Adicionar refrigerantes
        cardapio.addRefrigerante("Coca-Cola");
        cardapio.addRefrigerante("Pepsi Cola");
        cardapio.addRefrigerante("Guaraná Antartica");
        cardapio.addRefrigerante("Mineiro");

        //Adicionar sucos
        cardapio.addSuco("Laranja");
        cardapio.addSuco("Uva");
        cardapio.addSuco("Abacaxi");
        cardapio.addSuco("Limão");
    }
}