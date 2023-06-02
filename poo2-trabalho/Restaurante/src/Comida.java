public interface Comida {
    void preparar();
    void adicionarObserver(PedidoObserver observer);
    void removerObserver(PedidoObserver observer);
}
