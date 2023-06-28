import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        DadosRestaurante.inicializaDados();
        Scanner sc = new Scanner(System.in);
        ComidaFactory factory;
        Comida comida;
        int opc = 1;
        int verdadeiro = 1;
        while(opc==1){
        System.out.println("Mostrar Histórico de pedidos ou fazer pedido?");
        System.out.println("1 - mostrar Histórico");
        System.out.println("2 - fazer pedido");
        opc = sc.nextInt();

        if(opc == 1){
            DadosRestaurante.MostraDados();
        }
        }


        System.out.println("Bem-vindo ao menu! O que deseja comer?");
        System.out.println("1 - Lanche");
        System.out.println("2 - Pizza");
        System.out.println("3 - Pastel");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                factory = new LancheFactory();
                comida = criarComida(factory, sc);
                break;
            case 2:
                factory = new PizzaFactory();
                comida = criarComida(factory, sc);
                break;
            case 3:
                factory = new PastelFactory();
                comida = criarComida(factory, sc);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        while (verdadeiro==1) {
        System.out.println("Deseja colocar adicionais? ");
        System.out.println("1 - Mais queijo");
        System.out.println("2 - Ervilha");
        System.out.println("3 - Milho");
        System.out.println("4 - Ovo");
        System.out.println("5 - Não");
        int opcao2 = sc.nextInt();

        switch (opcao2) {
            case 1:
                comida = new MaisQueijo(comida);
                System.out.println("Mais queijo adicionado");
                break;
            case 2:
                comida = new Ervilha(comida);
                System.out.println("Ervilha adicionada");
                break;
            case 3:
                comida = new Milho(comida);
                System.out.println("Milho adicionado");
                break;
            case 4:
                comida = new Ovo(comida);
                System.out.println("Ovo adicionado");
                break;
            case 5:
                verdadeiro=0;
                break;
            default:
                System.out.println("opção invalida");
                break;
        }
    }



        System.out.println("Digite seu nome:");
        String nomeCliente = sc.next();
        

        PedidoObserver cliente = new Cliente(nomeCliente);
        comida.adicionarObserver(cliente);

        System.out.println("O restaurante ja recebeu o seu pedido.");
        
        comida.preparar();
        if(comida instanceof ComidaDecorator){
            System.out.print("Com adicionais: ");
            comida.MostrarAdicionais();
        }
        DadosRestaurante.cadastrar(comida);
    }

    public static Comida criarComida(ComidaFactory factory, Scanner sc) {
        String[] ingredientes;
        switch (factory.getClass().getSimpleName()) {
            case "LancheFactory":
                System.out.println("Escolha o tipo de hambúrguer:");
                String carne = sc.next();
                System.out.println("Escolha o tipo de queijo:");
                String queijo = sc.next();
                System.out.println("Escolha o tipo de salada:");
                String salada = sc.next();
                ingredientes = new String[]{carne, queijo, salada};
                return factory.criarComida(ingredientes);
            case "PizzaFactory":
                System.out.println("Escolha o tipo de borda:");
                String borda = sc.next();
                System.out.println("Escolha o tipo de massa:");
                String massa = sc.next();
                System.out.println("Escolha o tipo de recheio:");
                String recheio = sc.next();
                System.out.println("Escolha o tipo de queijo:");
                String queijoPizza = sc.next();
                ingredientes = new String[]{borda, massa, recheio, queijoPizza};
                return factory.criarComida(ingredientes);
            case "PastelFactory":
                System.out.println("Escolha o tipo de recheio:");
                String recheioPastel = sc.next();
                System.out.println("Escolha o tamanho do pastel:");
                String tamanho = sc.next();
                ingredientes = new String[]{recheioPastel, tamanho};
                return factory.criarComida(ingredientes);
            default:
                return null;
        }
    }
}

