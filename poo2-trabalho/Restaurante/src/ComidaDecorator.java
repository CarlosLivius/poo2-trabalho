import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class ComidaDecorator implements Comida,Serializable {
    protected Comida comida;
    private List<PedidoObserver> observers = new ArrayList<>();

    ComidaDecorator(Comida comida){
        this.comida = comida;
    }
    public void preparar(){
        comida.preparar();
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
        comida.MostrarAdicionais();
    }
    public void MostraComida(){
        comida.MostraComida();
    }
}
