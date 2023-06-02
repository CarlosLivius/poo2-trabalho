import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComidaFactory factory;
        Comida comida;

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

        System.out.println("Digite seu nome:");
        String nomeCliente = sc.next();
        

        PedidoObserver cliente = new Cliente(nomeCliente);
        comida.adicionarObserver(cliente);

        System.out.println("O restaurante ja recebeu o seu pedido.");
        
        comida.preparar();
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
