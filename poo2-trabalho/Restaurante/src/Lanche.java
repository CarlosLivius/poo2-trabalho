import java.util.ArrayList;
import java.util.List;

public class Lanche implements Comida {
    private String carne;
    private String queijo;
    private String salada;
    private List<PedidoObserver> observers = new ArrayList<>();

    public Lanche(String carne, String queijo, String salada) {
        this.carne = carne;
        this.queijo = queijo;
        this.salada = salada;
    }

    @Override
    public String preparar() {
        try {
            Thread.sleep(5000); // Aguarda 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notificarObservers();
        return "Lanche com hambúrguer de " + carne + ", queijo " + queijo + " e " + salada + " esta sendo preparado";
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
}