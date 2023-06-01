public class Cliente implements PedidoObserver {
    private String nome;
    private boolean pedidoPronto;

    public Cliente(String nome) {
        this.nome = nome;
        this.pedidoPronto = false;
    }

    public void atualizar(Comida pedido) {
        pedidoPronto = true;
        System.out.println("Cliente " + nome + ", o seu pedido está pronto!");
    }

    public boolean PedidoPronto() {
        return pedidoPronto;
    }

    public void setPedidoPronto(boolean pedidoPronto) {
        this.pedidoPronto = pedidoPronto;
    }
}
