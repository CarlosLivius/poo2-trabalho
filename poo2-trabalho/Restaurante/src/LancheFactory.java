public class LancheFactory extends ComidaFactory {
    @Override
    public Comida criarComida(String... ingredientes) {
        String carne = ingredientes[0];
        String queijo = ingredientes[1];
        String salada = ingredientes[2];
        return new Lanche(carne, queijo, salada);
    }
}