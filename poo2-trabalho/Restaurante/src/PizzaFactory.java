public class PizzaFactory extends ComidaFactory {
    @Override
    public Comida criarComida(String... ingredientes) {
        String borda = ingredientes[0];
        String massa = ingredientes[1];
        String recheio = ingredientes[2];
        String queijoPizza = ingredientes[3];
        return new Pizza(borda, massa, recheio, queijoPizza);
    }
}