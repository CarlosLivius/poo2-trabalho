import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public abstract class Comanda implements PedidoObserver {
    private List<Comida> pedidosProntos; // lista de pedidos marcados como prontos

    public Comanda() {
        this.pedidosProntos = new ArrayList<>();
    }

    @Override
    // chama o metodo atualizar do PedidoObserver quando o pedido ficar pronto
    public void atualizar(Comida pedido) {
        // adiciona o pedido pronto na lista de prontos
        pedidosProntos.add(pedido);
        // escreve no arquivo
        salvaPedido(pedido);
    }

    // escreve no arquivo
    private void salvaPedido(Comida pedido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("comanda.txt", true))) {
            writer.write("Pedido pronto: " + pedido.toString());
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao persistir o pedido: " + e.getMessage());
        }
    }

    // lê do arquivo
    public void lerComanda() {
        try (BufferedReader reader = new BufferedReader(new FileReader("comanda.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler a comanda: " + e.getMessage());
        }
    }
}
