import java.util.ArrayList;
import java.util.List;

public class Pizza implements Comida {
    private String borda;
    private String massa;
    private String recheio;
    private String queijo;
    private List<PedidoObserver> observers = new ArrayList<>();

    public Pizza(String borda, String massa, String recheio, String queijoPizza) {
        this.borda = borda;
        this.massa = massa;
        this.recheio = recheio;
        this.queijo = queijoPizza;
    }

    @Override
    public void preparar() {


        System.out.println("Pizza com borda " + borda + ", massa " + massa + ", recheio de " + recheio + " e queijo " + queijo + " está sendo preparada.");
        try {
            Thread.sleep(5000); // Aguarda 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notificarObservers();
    }

    @Override
    public void adicionarObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(PedidoObserver observer) {
        observers.remove(observer);
    }

    private void notificarObservers() {
        for (PedidoObserver observer : observers) {
            observer.atualizar(this);
        }
    }
    public void MostrarAdicionais(){

    }
}
