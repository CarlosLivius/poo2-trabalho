import java.util.ArrayList;
import java.util.List;

public class Pastel implements Comida {
    private String recheio;
    private String tamanho;
    private List<PedidoObserver> observers = new ArrayList<>();

    public Pastel(String recheio, String tamanho) {
        this.recheio = recheio;
        this.tamanho = tamanho;
    }

    @Override
    public String preparar() {
        String mensagem = "Pastel de " + recheio + " tamanho " + tamanho + " está sendo preparado.";

        System.out.println(mensagem);

        try {
            Thread.sleep(5000); // Aguarda 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notificarObservers();
        return mensagem;
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
