public interface Comida {
    String preparar();
    void adicionarObserver(PedidoObserver observer);
    void removerObserver(PedidoObserver observer);
}
